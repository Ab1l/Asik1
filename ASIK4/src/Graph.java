import java.util.*;

public class Graph {
    private Map<Vertex, List<Vertex>> adjacencyList = new LinkedHashMap<>();
    private Map<Integer, Vertex> vertexMap = new HashMap<>();

    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v, new ArrayList<>());
        vertexMap.put(v.getId(), v);
    }

    public void addEdge(int from, int to) {
        Vertex src = vertexMap.get(from);
        Vertex dst = vertexMap.get(to);
        if (src != null && dst != null) {
            adjacencyList.get(src).add(dst);
        }
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Vertex>> entry : adjacencyList.entrySet()) {
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
            for (Vertex neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
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
        for (Vertex neighbor : adjacencyList.getOrDefault(current, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public Map<Integer, Vertex> getVertexMap() {
        return vertexMap;
    }
}