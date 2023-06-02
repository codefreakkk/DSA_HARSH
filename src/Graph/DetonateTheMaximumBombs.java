package Graph;

import java.util.*;

public class DetonateTheMaximumBombs {

    private int dfs(List<List<Integer>> adj, int node, int[] visited) {
        visited[node] = 1;
        int count = 1;

        for (int element : adj.get(node)) {
            if (visited[element] == 0) {
                count += dfs(adj, element, visited);
            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int[] bomb1 = bombs[i];
                int[] bomb2 = bombs[j];

                if ((Math.pow(bomb1[0] - bomb2[0], 2) + Math.pow(bomb1[1] - bomb2[1], 2)) <= Math.pow(bomb1[2], 2)) {
                    adj.get(i).add(j);
                }
            }
        }

        int ans = 0;
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, 0);
            int count = dfs(adj, i, visited);
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
