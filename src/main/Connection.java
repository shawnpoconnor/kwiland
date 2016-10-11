public class Connection {
    private String destination;
    private int distance;

    public Connection(String destination, int distance) {

        this.destination = destination;
        this.distance = distance;
    }

    public String getDestination() { return this.destination; }

    public int getDistance() {
        return this.distance;
    }
}
