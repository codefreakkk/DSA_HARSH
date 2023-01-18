package Graph;

import java.util.*;

// bridges in graph --
// Tarjan's algorithm
public class BridgesInGraphTarjansAlgorithm {
    private int timer = 1;
    private void dfs(int node, int parent, List<List<Integer>> bridges, List<List<Integer>> adj, int[] visited, int[] inTime, int[] low) {
        visited[node] = 1;
        inTime[node] = low[node] = timer;
        timer++;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;

            if (visited[adjNode] == 0) {
                dfs(adjNode, node, bridges, adj, visited, inTime, low);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > inTime[node])
                    bridges.add(Arrays.asList(node, adjNode));
            }
            else
                low[node] = Math.min(low[node], low[adjNode]);
        }
    }

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[V];
        int[] inTime = new int[V];
        int[] low = new int[V];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, bridges, adj, visited, inTime, low);
        return bridges;
    }

    public static void main(String[] args) {

    }
}
