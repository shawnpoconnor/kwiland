import java.util.ArrayList;

public class RailSystem {
    private ArrayList<Town> allTowns;

    public RailSystem(ArrayList<Town> towns) {
        this.allTowns = towns;
    }

    public ArrayList<Town> getTowns() {
        return allTowns;
    }

    public Town findTown(String townName) {
        Town returnTown = null;
        for (int i = 0; i < allTowns.size(); i++) {

            if (allTowns.get(i).getName().equals(townName)) {
                returnTown = allTowns.get(i);
            }
        }
        return returnTown;
    }

    public Integer findRouteDistance(String[] strings) {
        int totalDistance = 0;

        try {
            if (allTowns.size() > 2) {

                for (int i = 0; i < strings.length - 1; i++) {
                    Town town = findTown(strings[i]);
                    Connection connection = town.findConnection(strings[i + 1]);
                    if (connection.getDestination() != null) {
                        totalDistance += connection.getDistance();
                    }
                }
            }
            return totalDistance;

        } catch (Exception ex) {
            System.out.println("NO SUCH ROUTE");
        }
        return null;

    }

    public int numberOfTripsWithMaxStops(String startString, String endString, int maxStops) {
        return findRoutesForMax(startString, endString, 0, maxStops);
    }

    public int numberOfTripsWithExactlyNStops(String startString, String endString, int exactStops) {
        return findRoutesForexact(startString, endString, 0, exactStops);
    }

    public int returnShortestDistance(String start, String end) {
        return findShortestDistance(start, end, 0, Integer.MAX_VALUE);
    }

    public int numberOfRoutesUnderLength(String startString, String endString, int maxDistance) {
        return findNumberOfRoutesUnderLength(startString, endString, 0, maxDistance);
    }

    private int findRoutesForMax(String startString, String endString, int stopNumber, int maxStops) {
        Town startTown = findTown(startString);
        Town endTown = findTown(endString);

        int completedRoutes = 0;

        stopNumber++;

        if (stopNumber > maxStops) {
            return 0;
        }

        for (Connection connection : startTown.getAllConnections()) {
            String destionTownName = connection.getDestination();

            if (destionTownName.equals(endTown.getName())) {
                completedRoutes++;
            } else {
                completedRoutes += findRoutesForMax(destionTownName, endString, stopNumber, maxStops);
            }
        }
        stopNumber--;
        return completedRoutes;
    }

    private int findRoutesForexact(String startString, String endString, int stopNumber, int exactStops) {
        Town startTown = findTown(startString);
        Town endTown = findTown(endString);

        int completedRoutes = 0;

        stopNumber++;

        if (stopNumber > exactStops) {
            return 0;
        }

        for (Connection connection : startTown.getAllConnections()) {
            String destionTownName = connection.getDestination();

            if (destionTownName.equals(endTown.getName()) && stopNumber == exactStops) {
                completedRoutes++;
            } else {
                completedRoutes += findRoutesForexact(destionTownName, endString, stopNumber, exactStops);
            }
        }
        return completedRoutes;
    }

    private int findShortestDistance(String startString, String endString, int prevousDistanceTransversed, int shortestDistance) {
        Town startTown = findTown(startString);

        startTown.setVisited(true);
        for (Connection connection : startTown.getAllConnections()) {

            Town destionTown = findTown(connection.getDestination());
            int currentDistanceTransversed = connection.getDistance() + prevousDistanceTransversed;

            if (destionTown.getName().equals(endString)) {
                if (currentDistanceTransversed < shortestDistance) {
                    shortestDistance = currentDistanceTransversed;
                }
                startTown.setVisited(false);
                return shortestDistance;
            } else if (!destionTown.getVisited()) {
                shortestDistance = findShortestDistance(destionTown.getName(), endString, currentDistanceTransversed, shortestDistance);
            }


        }
        startTown.setVisited(false);
        return shortestDistance;
    }

    private int findNumberOfRoutesUnderLength(String startString, String endString, int prevousDistanceTransversed, int maxDistance) {
        Town startTown = findTown(startString);

        int completedRoutes = 0;

        for (Connection connection : startTown.getAllConnections()) {

            String destionTownName = connection.getDestination();
            int currentDistanceTransversed = connection.getDistance() + prevousDistanceTransversed;

            if (currentDistanceTransversed < maxDistance) {
                if (destionTownName.equals(endString)) {

                    completedRoutes ++;
                    completedRoutes += findNumberOfRoutesUnderLength(destionTownName, endString, currentDistanceTransversed, maxDistance);
                }else  {
                    completedRoutes += findNumberOfRoutesUnderLength(destionTownName, endString, currentDistanceTransversed, maxDistance);
                }
            }

        }

        return completedRoutes;
    }
}