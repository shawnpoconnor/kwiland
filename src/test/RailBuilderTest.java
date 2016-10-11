import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RailBuilderTest {

    RailBuilder testBuilder = new RailBuilder();

    @Test
    public void findOrCreate() {
        ArrayList<Town> testTowns =  new ArrayList<>();

        Town t1 = new Town("A");
        Town t2 = new Town("B");
        Town t3 = new Town("C");

        testTowns.add(t1);
        testTowns.add(t2);
        testTowns.add(t3);

        testBuilder.findOrCreateTown("A", testTowns);

        assertThat(testTowns.size(), is(3));
    }

    @Test
    public void setTownArrayOutputsCorrectNumberOfTowns() {
        ArrayList<String[]> testInput =  new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "5"};
        String[] s2 = new String[] {"B", "C", "4"};
        String[] s3 = new String[] {"C", "D", "8"};
        String[] s4 = new String[] {"D", "C", "8"};
        String[] s5 = new String[] {"D", "E", "6"};
        String[] s6 = new String[] {"A", "D", "5"};
        String[] s7 = new String[] {"C", "E", "2"};
        String[] s8 = new String[] {"E", "B", "3"};
        String[] s9 = new String[] {"A", "E", "7"};

        testInput.add(s1);
        testInput.add(s2);
        testInput.add(s3);
        testInput.add(s4);
        testInput.add(s5);
        testInput.add(s6);
        testInput.add(s7);
        testInput.add(s8);
        testInput.add(s9);


        ArrayList<Town> result = testBuilder.setTownArray(testInput);

        assertThat(result.size(), is(5));
    }

    @Test
    public void setTownArrayOutputsCorrectTown() {
        ArrayList<String[]> testInput =  new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "5"};

        testInput.add(s1);

        ArrayList<Town> result = testBuilder.setTownArray(testInput);

        assertThat(result.get(0).getName(), is("A"));
    }

    @Test
    public void setTownArrayOutputsCorrectNumberOfRoutesInTown() {
        ArrayList<String[]> testInput =  new ArrayList<>();
        String[] s1 = new String[] {"A", "B", "5"};
        testInput.add(s1);

        ArrayList<Town> result = testBuilder.setTownArray(testInput);

        assertThat(result.get(0).numberOfConnections(), is(1));
    }

    @Test
    public void setTownArrayOutputsCorrectRoutesInTown() {
        ArrayList<String[]> testInput =  new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "5"};

        testInput.add(s1);

        //should create mock for towns and routes
        assertThat(testBuilder.setTownArray(testInput).get(0).findConnection("B").getDestination(), is("B"));
    }

    @Test
    public void doesNotCreateTwoOfTheSameTowns() {
        ArrayList<String[]> testInput =  new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "5"};
        String[] s2 = new String[] {"A", "C", "6"};

        testInput.add(s1);
        testInput.add(s2);

        ArrayList<Town> result = testBuilder.setTownArray(testInput);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).numberOfConnections(), is(2));
    }
}