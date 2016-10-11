import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConnectionTest {
    Connection testConnection = new Connection("B", 2);

    @Test
    public void getDirection() {
        assertThat(testConnection.getDestination(), is("B"));
    }

    @Test
    public void getDistance() throws Exception {
        assertThat(testConnection.getDistance(), is(2));
    }

}