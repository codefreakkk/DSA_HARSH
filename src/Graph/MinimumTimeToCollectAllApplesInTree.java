package Graph;

import java.util.*;

public class MinimumTimeToCollectAllApplesInTree {
    public int dfs(int node, List<List<Integer>> adj, List<Boolean> hasApple, int[] visited) {
        visited[node] = 1;
        int ans = 0;

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                ans += dfs(adjNode, adj, hasApple, visited);
            }
        }
        if (node == 0) return ans;
        if (ans > 0) return ans + 2;
        if (hasApple.get(node)) return 2;
        return 0;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[n];
        return dfs(0, adj, hasApple, visited);
    }

    public static void main(String[] args) {
        int[][] edges = {
            {0, 1},{0, 2},{1, 4},{1, 5},{2, 3},{2, 6}
        };
        MinimumTimeToCollectAllApplesInTree o = new MinimumTimeToCollectAllApplesInTree();
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) list.add(false);
        list.set(2, true);
        list.set(4, true);
        list.set(5, true);
        System.out.println(o.minTime(7, edges, list));
    }
}
