package Graph;

import java.util.ArrayList;

public class DetectACycleInDirectedGraphDFS {

    // using 2 visited arrays
    public boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                if (detectCycle(adjacentNode, adj, visited, pathVisited))
                    return true;
            }
            else if (pathVisited[adjacentNode] == 1)
                return true;
        }
        pathVisited[node] = 0;
        return false;
    }

    // using 2 visited arrays
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];
        int[] pathVisited = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, adj, visited, pathVisited))
                    return true;
            }
        }
        return false;
    }

    // using 1 visited array
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 2;
        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                if (dfs(adjacentNode, adj, visited))
                    return true;
            }
            else if (visited[adjacentNode] == 2)
                return true;
        }
        if (visited[node] == 2)
            visited[node] = 1;

        return false;
    }

    // using 1 visited array
    public boolean isCycleUsingOneArray(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
