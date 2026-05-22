import java.util.*;

public class Graph {
    private Map<Vertex, List<Edge>> adjacencyList = new LinkedHashMap<>();
    private Map<Integer, Vertex> vertexMap = new HashMap<>();

    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
        vertexMap.put(v.getId(), v);
    }

    public void addEdge(int from, int to, int weight) {
        Vertex src = vertexMap.get(from);
        Vertex dst = vertexMap.get(to);
        if (src != null && dst != null) {
            adjacencyList.get(src).add(new Edge(src, dst, weight));
        }
    }

    // Overload for unweighted edges (default weight = 1)
    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Edge>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // BFS: uses a queue, visits level by level. O(V + E)
    public void bfs(int start) {
        Vertex startVertex = vertexMap.get(start);
        if (startVertex == null) return;

        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        visited.add(startVertex);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current + " ");
            for (Edge edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                Vertex neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS: uses recursion, goes deep before backtracking. O(V + E)
    public void dfs(int start) {
        Vertex startVertex = vertexMap.get(start);
        if (startVertex == null) return;

        System.out.print("DFS: ");
        dfsHelper(startVertex, new LinkedHashSet<>());
        System.out.println();
    }

    private void dfsHelper(Vertex current, Set<Vertex> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (Edge edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
            Vertex neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra: finds shortest path from start to all other vertices. O(V^2)
    public void dijkstra(int start) {
        Vertex startVertex = vertexMap.get(start);
        if (startVertex == null) return;

        Map<Vertex, Integer> dist = new HashMap<>();
        Set<Vertex> visited = new HashSet<>();

        // Initialize all distances to infinity
        for (Vertex v : adjacencyList.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
        }
        dist.put(startVertex, 0);

        for (int i = 0; i < adjacencyList.size(); i++) {
            // Pick the unvisited vertex with the smallest distance
            Vertex current = null;
            for (Vertex v : adjacencyList.keySet()) {
                if (!visited.contains(v)) {
                    if (current == null || dist.get(v) < dist.get(current)) {
                        current = v;
                    }
                }
            }

            if (current == null || dist.get(current) == Integer.MAX_VALUE) break;
            visited.add(current);

            // Relax edges
            for (Edge edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                Vertex neighbor = edge.getDestination();
                int newDist = dist.get(current) + edge.getWeight();
                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                }
            }
        }

        // Print results
        System.out.println("Dijkstra from vertex " + start + ":");
        for (Map.Entry<Vertex, Integer> entry : dist.entrySet()) {
            String d = entry.getValue() == Integer.MAX_VALUE ? "unreachable" : String.valueOf(entry.getValue());
            System.out.println("  to " + entry.getKey() + " = " + d);
        }
    }

    public Map<Integer, Vertex> getVertexMap() { return vertexMap; }
}