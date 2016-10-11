import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ParserTest {
    Parser testParser = new Parser();

    @Test
    public void splitsAtCapitals() {
        String testInput = "AB";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"A", "B"};

        expectedStringArray.add(s1);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }

    @Test
    public void splitsAtCapitalsWhenOtherLettersInBetween() {
        String testInput = "AtlantaBrooklyn";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"Atlanta", "Brooklyn"};

        expectedStringArray.add(s1);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }

    @Test
    public void splitsAtCapitalAndNumber() {
        String testInput = "AB5";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "5"};

        expectedStringArray.add(s1);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }

    @Test
    public void splitsAtCapitalsAndNumbersWhenWholeWordEntered() {
        String testInput = "AtlantaBrooklyn5";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"Atlanta", "Brooklyn", "5"};

        expectedStringArray.add(s1);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }


    @Test
    public void correctlyParsesMultipleinput() {
        String testInput = "AB5, BC4, CD8";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "5"};
        String[] s2 = new String[] {"B", "C", "4"};
        String[] s3 = new String[] {"C", "D", "8"};

        expectedStringArray.add(s1);
        expectedStringArray.add(s2);
        expectedStringArray.add(s3);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }

    @Test
    public void correctlyParsesMultipleVaryingLetterinput() {
        String testInput = "AtlantaB5, BChicago4, CD8";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"Atlanta", "B", "5"};
        String[] s2 = new String[] {"B", "Chicago", "4"};
        String[] s3 = new String[] {"C", "D", "8"};

        expectedStringArray.add(s1);
        expectedStringArray.add(s2);
        expectedStringArray.add(s3);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }

    @Test
    public void correctlyParsesvaryingLetterAndNumberInput() {
        String testInput = "AB55, BrooklynChicago4444, CDetroit82";
        ArrayList<String[]> expectedStringArray = new ArrayList<>();

        String[] s1 = new String[] {"A", "B", "55"};
        String[] s2 = new String[] {"Brooklyn", "Chicago", "4444"};
        String[] s3 = new String[] {"C", "Detroit", "82"};

        expectedStringArray.add(s1);
        expectedStringArray.add(s2);
        expectedStringArray.add(s3);

        for (int i = 0; i < expectedStringArray.size() ; i++) {
            for (int j = 0; j < expectedStringArray.get(i).length; j++) {
                assertThat(testParser.formatInput(testInput).get(i)[j], is(expectedStringArray.get(i)[j]));
            }
        }
    }




}