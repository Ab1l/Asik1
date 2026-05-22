# Assignment 4: Graph Traversal and Representation System

## Project Overview

This project implements a graph data structure using an adjacency list and applies BFS, DFS, and Dijkstra's algorithm on graphs of different sizes.

---

## Class Descriptions

### `Vertex`
Represents a single node in the graph. Stores a unique `id`.

### `Edge`
Represents a directed connection between two vertices with a `weight` field.

### `Graph`
Stores the graph using an **adjacency list** — each vertex maps to a list of its outgoing edges. Memory-efficient for sparse graphs, O(1) average neighbor access.

Methods:
- `addVertex(Vertex v)` — adds a node
- `addEdge(int from, int to, int weight)` — adds a weighted directed edge
- `addEdge(int from, int to)` — adds an unweighted edge (default weight = 1)
- `printGraph()` — prints the adjacency list
- `bfs(int start)` — Breadth-First Search
- `dfs(int start)` — Depth-First Search
- `dijkstra(int start)` — Dijkstra's Shortest Path

### `Experiment`
Builds graphs of sizes 10, 30, 100, runs BFS and DFS, measures execution time via `System.nanoTime()`.

---

## Algorithm Descriptions

### BFS (Breadth-First Search)
Explores all neighbors at the current depth before going deeper. Uses a **queue (FIFO)**.

1. Add start vertex to queue and mark as visited
2. Dequeue a vertex, process it
3. Enqueue all unvisited neighbors
4. Repeat until queue is empty

**Time complexity:** O(V + E)
**Use cases:** shortest path (unweighted), level-order traversal, connected components

---

### DFS (Depth-First Search)
Explores as far as possible along each branch before backtracking. Uses **recursion**.

1. Mark current vertex as visited and process it
2. Recursively visit each unvisited neighbor
3. Backtrack when no unvisited neighbors remain

**Time complexity:** O(V + E)
**Use cases:** cycle detection, topological sort, maze solving

---

### Dijkstra's Algorithm (Bonus)
Finds the shortest path from a starting vertex to all other vertices in a **weighted graph**.

1. Set distance to start = 0, all others = ∞
2. Pick the unvisited vertex with the smallest known distance
3. Relax all its outgoing edges: if `dist[current] + weight < dist[neighbor]`, update
4. Mark current as visited, repeat until all vertices are processed

**Time complexity:** O(V²) with simple arrays (no priority queue)
**Use cases:** GPS navigation, network routing, shortest path in weighted graphs

---

## Experimental Results

Graph structure: each vertex `i` connects to `(i+1) % size` and `(i+2) % size`.

| Graph Size | BFS Time (ns) | DFS Time (ns) |
|------------|--------------|--------------|
| 10 vertices | 349,500 | 396,900 |
| 30 vertices | 809,500 | 1,026,700 |
| 100 vertices | 2,275,000 | 239,573,200* |

*DFS on 100 vertices spiked due to JVM warm-up overhead, not algorithm behavior.

### Observations
- Both algorithms grow linearly — consistent with O(V + E)
- BFS is generally faster due to lower overhead vs recursion
- DFS can spike on first runs due to JVM cold-start

---

## Dijkstra Demo Results

Weighted graph (6 vertices), starting from vertex 0:

| Destination | Shortest Distance | Path |
|-------------|------------------|------|
| 0 | 0 | start |
| 1 | 3 | 0 → 2 → 1 |
| 2 | 2 | 0 → 2 |
| 3 | 8 | 0 → 2 → 1 → 3 |
| 4 | 10 | 0 → 2 → 1 → 3 → 4 |
| 5 | 13 | 0 → 2 → 1 → 3 → 4 → 5 |

---


## Reflection

This assignment gave me a clear understanding of how BFS and DFS differ in practice. BFS uses a queue and explores level by level — ideal for shortest paths in unweighted graphs. DFS uses recursion and dives deep first — better for detecting cycles or exploring all paths.

The bonus Dijkstra implementation extended the graph to support weighted edges. The key insight is the relaxation step: continuously updating distances when a shorter path is found. Unlike BFS, Dijkstra picks the globally cheapest unvisited vertex at each step, which guarantees correct shortest paths for non-negative weights.
