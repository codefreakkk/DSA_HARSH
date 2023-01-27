package Graph;

import java.util.*;

public class BridgeEdgeInAGraph {

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                visited[adjNode] = 1;
                dfs(adjNode, adj, visited);
            }
        }
    }

    public static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        int[] visited = new int[V];
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        dfs(c, adj, visited);
        return visited[d] == 0 ? 1 : 0;
    }
    public static void main(String[] args) {

    }
}
