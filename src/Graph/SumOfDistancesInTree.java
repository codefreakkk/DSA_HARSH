package Graph;

import java.util.*;
// problem not solved
public class SumOfDistancesInTree {

    private int dfs(List<List<Integer>> adj, int[] visited, int node) {
        visited[node] = 1;

        int sum = 0;
        for (int element : adj.get(node)) {
            if (visited[element] == 0) {
                sum += dfs(adj, visited, node) + 1;
            }
        }
        return sum;
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            int count = dfs(adj, visited, i);
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
