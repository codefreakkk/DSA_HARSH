package Graph;

import java.util.*;

public class DetectACycleInUndirectedGraphDFS {
    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                if (dfs(adjacentNode, node, adj, visited))
                    return true;
            }
            else if (adjacentNode != parent)
                return true;
        }
        return false;
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];
        for (int i = 0; i < v; i++) {
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
