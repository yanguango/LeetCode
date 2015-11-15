class Graph {
    public int vsize;
    public List<Integer>[] adj;

    public Graph(int v) {
        vsize = v;
        adj = new ArrayList[vsize];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
}

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) return n == 1;
        Graph g = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }
        boolean[] visited = new boolean[n];
        if (hasCycle(g, visited, edges[0][0], -1)) {
            return false;
        } else {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) return false;
            }
        }
        return true;
    }

    public boolean hasCycle(Graph g, boolean[] visited, int v, int parent) {
        visited[v] = true;
        for (Integer a : g.adj[v]) {
            if (!visited[a]) {
                if (hasCycle(g, visited, a, v));
            } else if (a != parent) {
                return true;
            }
        }
        return false;
    }
}