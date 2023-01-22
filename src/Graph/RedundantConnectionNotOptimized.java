package Graph;

import java.util.*;

public class RedundantConnectionNotOptimized {
    public boolean dfs(int node, int parent, List<List<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                if (dfs(adjNode, node, adj, visited))
                    return true;
            }
            else if (parent != adjNode)
                return true;
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;


        int[] res = new int[2];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            int[] visited = new int[V + 1];

            if (dfs(u, -1, adj, visited)) {
                res[0] = u;
                res[1] = v;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
