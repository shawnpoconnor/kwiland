import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class RailSystemTest {

    RailSystem testRailSystem = testTownConstructor1();
    RailSystem simpleRailSystem = testTownConstructor2();
    RailSystem simpleRailSystem2 = testTownConstructor3();

    public RailSystem testTownConstructor1() {
//        Town t1 = new Town("A");
//        t1.addConnection("B", 5);
//        t1.addConnection("D", 5);
//        t1.addConnection("E", 7);
//
//        Town t2 = new Town("B");
//        t2.addConnection("C", 4);
//
//        Town t3 = new Town("C");
//        t3.addConnection("D", 8);
//        t3.addConnection("E", 2);
//
//        Town t4 = new Town("D");
//        t4.addConnection("C", 8);
//        t4.addConnection("E", 6);
//
//        Town t5 = new Town("E");
//        t5.addConnection("B", 3);
//
//        ArrayList<Town> towns = new ArrayList<Town>(Arrays.asList(t1, t2, t3, t4, t5));
//
//        return new RailSystem(towns);

        RailBuilder builder = new RailBuilder();
        Parser parser = new Parser();
        return new RailSystem(builder.setTownArray(parser.formatInput("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7")));
    }

    public RailSystem testTownConstructor2() {
        Town t1 = new Town("A");
        t1.addConnection("B", 5);

        Town t2 = new Town("B");
        t2.addConnection("C", 4);
        t2.addConnection("A", 1);

        Town t3 = new Town("C");
        t3.addConnection("A", 8);


        ArrayList<Town> towns = new ArrayList<Town>(Arrays.asList(t1, t2, t3));

        return new RailSystem(towns);
    }


    public RailSystem testTownConstructor3() {
        Town t1 = new Town("A");
        t1.addConnection("B", 1);
        t1.addConnection("C", 1);

        Town t2 = new Town("B");
        t2.addConnection("C", 4);
        t2.addConnection("A", 1);

        Town t3 = new Town("C");
        t3.addConnection("A", 8);


        ArrayList<Town> towns = new ArrayList<Town>(Arrays.asList(t1, t2, t3));

        return new RailSystem(towns);
    }

    @Test
    public void canFindFirstTownInList() {
        assertThat(testRailSystem.findTown("A").getName(), is("A"));
    }

    @Test
    public void canFindLastTownInList() {
        assertThat(testRailSystem.findTown("E").getName(), is("E"));
    }

    @Test
    public void canFindTownInMiddleOfList() {
        assertThat(testRailSystem.findTown("C").getName(), is("C"));
    }

    @Test
    public void returnsNoTownMessageWhenNoTownExists() {
        assertThat(testRailSystem.findTown("Z"), is(nullValue()));
    }

    @Test
    public void returnsCorrectDistanceOfInputedRoute_ABC() {
        String[] strings = new String[3];
        strings[0] = "A";
        strings[1] = "B";
        strings[2] = "C";

        assertThat(testRailSystem.findRouteDistance(strings), is(9));
    }

    @Test
    public void returnsCorrectDistanceOfInputedRoute_AD() {
        String[] strings = new String[2];
        strings[0] = "A";
        strings[1] = "D";

        assertThat(testRailSystem.findRouteDistance(strings), is(5));
    }

    @Test
    public void returnsCorrectDistanceOfInputedRoute_ADC() {
        String[] strings = new String[3];
        strings[0] = "A";
        strings[1] = "D";
        strings[2] = "C";

        assertThat(testRailSystem.findRouteDistance(strings), is(13));
    }

    @Test
    public void returnsCorrectDistanceOfInputedRoute_AEBCD() {
        String[] strings = new String[5];
        strings[0] = "A";
        strings[1] = "E";
        strings[2] = "B";
        strings[3] = "C";
        strings[4] = "D";

        assertThat(testRailSystem.findRouteDistance(strings), is(22));
    }

    @Test
    public void returnsCorrectDistanceOfInputedRoute_AEC() {
        String[] strings = new String[3];
        strings[0] = "A";
        strings[1] = "E";
        strings[2] = "D";

        assertThat(testRailSystem.findRouteDistance(strings), is(nullValue()));
    }

    @Test
    public void returnsCorrectNumberOfStopsUsingMaxMethod_CC3() {
        assertThat(testRailSystem.numberOfTripsWithMaxStops("C", "C", 3), is(2));
    }

    @Test
    public void returnsCorrectNumberOfStopsUsingMaxMethodDoublingBackOnce() {
        assertThat(simpleRailSystem.numberOfTripsWithMaxStops("A", "C", 4), is(2));
    }

    @Test
    public void returnsCorrectNumberOfStopsUsingMaxMethodDoublingBackTwice() {
        assertThat(simpleRailSystem.numberOfTripsWithMaxStops("A", "C", 6), is(3));
    }

    @Test
    public void returnsCorrectNumberOfStopsUsingMaxMethod() {
        assertThat(testRailSystem.numberOfTripsWithMaxStops("A", "C", 4), is(4));
    }

    @Test
    public void returnsCorrectNumberOfStopsUsingExactMethod() {
        assertThat(testRailSystem.numberOfTripsWithExactlyNStops("A", "C", 4), is(3));
    }

    @Test
    public void returnCorrectShortestDistance_AC_InSimpleGraph() {
        assertThat(simpleRailSystem2.returnShortestDistance("A", "C"), is(1));
    }

    @Test
    public void returnCorrectShortestDistance_AC_inComplexGraph() {
        assertThat(testRailSystem.returnShortestDistance("A", "C"), is(9));
    }

    @Test
    public void returnCorrectShortestDistance_BB_inComplexGraph() {
        assertThat(testRailSystem.returnShortestDistance("B", "B"), is(9));
    }

    @Test
    public void returnCorrectNumberOfRoutesUnder7_AA_InSimpeGraph() {
        assertThat(simpleRailSystem2.numberOfRoutesUnderLength("A", "A", 7), is(3));
    }

    @Test
    public void returnCorrectNumberOfRoutesUnder6_CC_InSimpeGraph() {
        assertThat(testRailSystem.numberOfRoutesUnderLength("C", "C", 30), is(7));
    }
}