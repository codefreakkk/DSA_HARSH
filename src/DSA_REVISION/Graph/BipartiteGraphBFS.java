package DSA_REVISION.Graph;

import java.util.*;

public class BipartiteGraphBFS {

    public boolean detectBipartite(int node, int[][] graph, int[] color) {
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

        color[node] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int adjNode : adjList.get(currentNode)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = color[currentNode] == 0 ? 1 : 0;
                    queue.offer(adjNode);
                } else if (color[currentNode] == color[adjNode]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!detectBipartite(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

}
