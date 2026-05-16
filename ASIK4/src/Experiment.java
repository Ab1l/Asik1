public class Experiment {
    private int size;
    private long bfsTime;
    private long dfsTime;

    public Experiment(int size) {
        this.size = size;
    }

    // Runs BFS and DFS, measures time in nanoseconds
    public void runTraversals(Graph g) {
        long start, end;

        start = System.nanoTime();
        g.bfs(0);
        end = System.nanoTime();
        bfsTime = end - start;

        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();
        dfsTime = end - start;
    }

    // Builds a graph of given size, runs traversals
    public void runMultipleTests() {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }
        // Add edges: each vertex connects to next two (circular)
        for (int i = 0; i < size; i++) {
            g.addEdge(i, (i + 1) % size);
            g.addEdge(i, (i + 2) % size);
        }
        runTraversals(g);
    }

    public void printResults() {
        System.out.println("Graph size: " + size + " vertices");
        System.out.println("  BFS time: " + bfsTime + " ns");
        System.out.println("  DFS time: " + dfsTime + " ns");
        System.out.println();
    }
}