package Graph;

import java.util.ArrayList;

public class CourseSchedule {
    private void convertIntoAdjacencyList(int n, int[][] edges, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
    }
    private boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited) {
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

    public boolean isCycle(int v, int[][] edges) {
        int[] visited = new int[v];
        int[] pathVisited = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        convertIntoAdjacencyList(v, edges, adj);

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, adj, visited, pathVisited))
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
