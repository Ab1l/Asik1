public class Main {
    public static void main(String[] args) {

        // --- Small graph (10 vertices) ---
        System.out.println("=== Small Graph (10 vertices) ===");
        Graph small = new Graph();
        for (int i = 0; i < 10; i++) small.addVertex(new Vertex(i));
        for (int i = 0; i < 10; i++) {
            small.addEdge(i, (i + 1) % 10);
            small.addEdge(i, (i + 2) % 10);
        }
        System.out.println("Graph structure:");
        small.printGraph();
        System.out.println();
        small.bfs(0);
        small.dfs(0);
        System.out.println();

        // --- Performance experiments ---
        System.out.println("=== Performance Experiments ===");
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            Experiment exp = new Experiment(size);
            exp.runMultipleTests();
            exp.printResults();
        }

        // --- Bonus: Dijkstra demo ---
        System.out.println("=== Bonus: Dijkstra Shortest Path ===");
        Graph weighted = new Graph();
        for (int i = 0; i < 6; i++) weighted.addVertex(new Vertex(i));

        weighted.addEdge(0, 1, 4);
        weighted.addEdge(0, 2, 2);
        weighted.addEdge(1, 3, 5);
        weighted.addEdge(2, 1, 1);
        weighted.addEdge(2, 3, 8);
        weighted.addEdge(3, 4, 2);
        weighted.addEdge(4, 5, 3);
        weighted.addEdge(3, 5, 6);

        System.out.println("Weighted graph structure:");
        weighted.printGraph();
        System.out.println();
        weighted.dijkstra(0);
    }
}