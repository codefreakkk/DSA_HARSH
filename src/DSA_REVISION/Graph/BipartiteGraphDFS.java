package DSA_REVISION.Graph;

import java.util.*;

public class BipartiteGraphDFS {

    public boolean detectBipartite(int node, List<List<Integer>> adjList, int[] color) {
        for (int adjNode : adjList.get(node)) {
            if (color[adjNode] == -1) {
                color[adjNode] = 1 - color[node];
                if (!detectBipartite(adjNode, adjList, color)) {
                    return false;
                }
            } else if (color[node] == color[adjNode]) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // construct graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!detectBipartite(i, adjList, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
