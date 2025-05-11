package DSA_REVISION.Graph;

import java.util.*;

public class DetectCycleInUndirectedGraphDFS {

    private boolean dfs(int node, int parent, List<List<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                if (dfs(adjNode, node, adj, visited)) {
                    return true;
                }
            } else if (adjNode != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int v, int[][] edges) {
        int[] visited = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int vv = edge[1];
            adj.get(u).add(vv);
            adj.get(vv).add(u);
        }
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
