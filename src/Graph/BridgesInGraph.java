package Graph;

import java.util.*;

public class BridgesInGraph {
    private int timer = 1;
    private void dfs(int node, int parent, int[] low, int[] inTime, int[] visited, List<List<Integer>> adj, List<List<Integer>> ans) {
        visited[node] = 1;
        inTime[node] = low[node] = timer++;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;

            if (visited[adjNode] == 0) {
                dfs(adjNode, node, low, inTime, visited, adj, ans);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > inTime[node]) {
                    ans.add(Arrays.asList(node, adjNode));
                }
            }
            else
                low[node] = Math.min(low[node], low[adjNode]);
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] inTime = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, -1, low, inTime, visited, adj, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
