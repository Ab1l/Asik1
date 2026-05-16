/**
 * Represents a node (vertex) in the graph.
 */
public class Vertex {

    private int id;

    /**
     * Constructor to create a vertex with a given id.
     * @param id unique identifier for the vertex
     */
    public Vertex(int id) {
        this.id = id;
    }

    /**
     * Returns the unique identifier of this vertex.
     * @return vertex id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns a string representation of the vertex.
     * @return string in format "Vertex(id)"
     */
    @Override
    public String toString() {
        return "Vertex(" + id + ")";
    }
}