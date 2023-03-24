package JUST_CODES;
import java.util.*;
public class MakeAllPathsLeadToCity0 {

    private int solve(int node, List<List<Integer>> adj, List<List<Integer>> adjRev, int[] visited) {
        int count = 0;
        visited[node] = 1;

        // check for possible ans
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0)
                count++;
        }

        // dfs
        for (int adjNode : adjRev.get(node)) {
            if (visited[adjNode] == 0) {
                count += solve(adjNode, adj, adjRev, visited);
            }
        }
        return count;
    }

    public int minReorder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }

        // make adjList
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        // rev edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjRev.get(u).add(v);
            adjRev.get(v).add(u);
        }

        int[] visited = new int[n];
        return solve(0, adj, adjRev, visited);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0}, {1, 2}, {3, 2},{3, 4}
        };
        int n = 5;
        MakeAllPathsLeadToCity0 o = new MakeAllPathsLeadToCity0();
        System.out.println(o.minReorder(n, grid));
    }
}
