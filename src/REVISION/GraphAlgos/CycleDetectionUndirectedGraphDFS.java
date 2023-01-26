package REVISION.GraphAlgos;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraphDFS {
    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                if (dfs(adjNode, node, adj, visited))
                    return true;
            }
            else if (adjNode != parent)
                return true;
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
