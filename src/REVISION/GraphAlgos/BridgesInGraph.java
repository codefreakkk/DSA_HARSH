package REVISION.GraphAlgos;

import java.util.*;

public class BridgesInGraph {
    private int timer = 1;
    private void dfs(int node, List<List<Integer>> adj, List<List<Integer>> ans, int[] inTime, int[] low, int[] visited) {
        visited[node] = 1;
        inTime[node] = low[node] = timer++;

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                dfs(adjNode, adj, ans, inTime, low, visited);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > inTime[node]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(adjNode);
                    ans.add(temp);
                }
            }
            else low[node] = Math.min(low[node], low[adjNode]);
        }
    }

    public List<List<Integer>> bridge(int n, List<List<Integer>> con) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> edge : con) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] inTime = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, adj, ans, inTime, low, visited);
        return ans;
    }

    public static void main(String[] args) {

    }
}
