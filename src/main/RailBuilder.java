import java.util.ArrayList;

public class RailBuilder {
    
    public ArrayList<Town> setTownArray(ArrayList<String[]> parsedInput) {
        ArrayList<Town> townArray = new ArrayList<>();

        for (String[] eachRoute : parsedInput){
            String townName = eachRoute[0];
            String routeDirection = eachRoute[1];
            int routeDistance = Integer.parseInt(eachRoute[2]);
            Town townToAddRoutTo = findOrCreateTown(townName, townArray);

            if (townToAddRoutTo != null) {
                townToAddRoutTo.addConnection(routeDirection, routeDistance);
            }

        }

        return townArray;
    }

    protected Town findOrCreateTown(String townName, ArrayList<Town> townArray) {
        Town returnTown = null;
        int numberOfTowns = townArray.size();

        if (numberOfTowns == 0) {
            returnTown = new Town(townName);
            townArray.add(returnTown);
            return returnTown;
        }
        for (int i = 0; i < numberOfTowns; i++) {
            if (townArray.get(i).getName().equals(townName)) {
                return townArray.get(i);
            } else if (i == numberOfTowns - 1){
                returnTown = new Town(townName);
                townArray.add(returnTown);
                return returnTown;
            }
        }

        return returnTown;
    }

}