import java.util.ArrayList;

public class Town {
    private String townName;
    private boolean visited;
    private ArrayList<Connection> connections = new ArrayList<Connection>();

    public Town(String townName) {
        this.townName = townName;
        this.visited = false;
    }

    public void addConnection(String direction, int distance) {
        connections.add(new Connection(direction, distance));
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean setValue) {
        visited = setValue;
    }

    public Connection findConnection(String ConnectionName) {
        Connection foundConnection = null;

        for (int i = 0; i < connections.size(); i++) {
            Connection connection = connections.get(i);
            if (connection.getDestination().equals(ConnectionName)) {
                foundConnection = connection;
            }
        }
        return foundConnection;
    }

    public String getName() {
        return townName;
    }

    public ArrayList<Connection> getAllConnections() { return connections; }

    public int numberOfConnections() {
        return connections.size();
    }


}
