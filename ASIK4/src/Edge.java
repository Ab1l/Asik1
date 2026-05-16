/**
 * Represents a directed edge (connection) between two vertices in the graph.
 */
public class Edge {

    private Vertex source;
    private Vertex destination;

    /**
     * Constructor to create an edge from source to destination.
     * @param source      the starting vertex
     * @param destination the ending vertex
     */
    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * Returns the source (starting) vertex of this edge.
     * @return source vertex
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * Returns the destination (ending) vertex of this edge.
     * @return destination vertex
     */
    public Vertex getDestination() {
        return destination;
    }

    /**
     * Returns a string representation of the edge.
     * @return string in format "Edge(source -> destination)"
     */
    @Override
    public String toString() {
        return "Edge(" + source + " -> " + destination + ")";
    }
}