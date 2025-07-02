package DSA_REVISION.Graph;

import java.util.*;

// bridges in graph
public class CriticalConnectionsInNetwork {
    private int timer = 1;

    private void dfs(int node, int parent, int[] visited, int[] inTime, int[] low, List<List<Integer>> adjList, List<List<Integer>> bridges) {
        visited[node] = 1;
        inTime[node] = timer;
        low[node] = timer;
        timer++;

        for (int adjNode : adjList.get(node)) {
            if (adjNode == parent) {
                continue;
            }

            if (visited[adjNode] == 0) {
                dfs(adjNode, node, visited, inTime, low, adjList, bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > inTime[node]) {
                    bridges.add(List.of(node, adjNode));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int V = connections.size();
        List<List<Integer>> adjList = new ArrayList<>();

        // build graph
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] inTime = new int[V];
        int[] low = new int[V];
        int[] visited = new int[V];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, visited, inTime, low, adjList, bridges);
        return bridges;
    }
}
