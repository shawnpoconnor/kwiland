import java.util.ArrayList;

public class Parser {

    private String[] splitOnWhitespaceAndComma(String input) {
        return input.split(", ");
    }

    private ArrayList<String[]> splitEachRouteInput(String[] splitUnformattedRouteInfo) {

        ArrayList<String[]> formattedRouteInfo = new ArrayList<>();

        for (String routeInfo : splitUnformattedRouteInfo) {
            formattedRouteInfo.add(routeInfo.split("(?=\\p{Upper})|(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"));
        }

        return formattedRouteInfo;

    }

    public  ArrayList<String[]> formatInput(String input) {
        String[] splitUnformattedRouteInfo = splitOnWhitespaceAndComma(input);

        return splitEachRouteInput(splitUnformattedRouteInfo);
    }

}
