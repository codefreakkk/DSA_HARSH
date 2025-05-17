package DSA_REVISION.Graph;

import java.util.*;

public class DetectCycleForDirectedGraph {

    public boolean dfs(int node, List<List<Integer>> adjList, int[] visited, int[] pathVisited) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int adjNode : adjList.get(node)) {
            if (visited[adjNode] == 0) {
                if (dfs(adjNode, adjList, visited, pathVisited)) {
                    return true;
                }
            } else if (visited[adjNode] == 1 && pathVisited[adjNode] == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {
        int n = edges.length;

        // construct graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
        }

        int[] visited = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adjList, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

}
