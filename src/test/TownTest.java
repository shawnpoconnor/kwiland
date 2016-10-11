import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class TownTest {
    Town testTown = mockTownConstructor();
    public Town mockTownConstructor() {
        Town testTown = new Town("T");
        testTown.addConnection("C", 2);
        testTown.addConnection("B", 5);
        testTown.addConnection("A", 3);

        return testTown;
    }

    @Test
    public void canFindFirstTownInList() {
        assertThat(testTown.findConnection("A").getDestination(), is("A"));
    }

    @Test
    public void canFindTownInCenterOfList() {
        assertThat(testTown.findConnection("B").getDestination(), is("B"));
    }

    @Test
    public void canFindLastTownInList() {
        assertThat(testTown.findConnection("C").getDestination(), is("C"));
    }

    @Test
    public void returnsNullIfNoTown() {
        assertThat(testTown.findConnection("Z"), is(nullValue()));
    }

//    @Test
//    public void getAllConnections() {
//        testTown.addConnection("B", 5);
//        testTown.addConnection("C", 6);
//        assertThat(testTown.getRoute(1).getClass(), is("Connection"));
//    }

    @Test
    public void getAllRoutes() {
        assertThat(testTown.numberOfConnections(), is(3));
    }

}