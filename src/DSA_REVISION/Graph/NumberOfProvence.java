package DSA_REVISION.Graph;

import java.util.*;

public class NumberOfProvence {

    private void dfs(int node, int[] visited, List<List<Integer>> adjList) {
        visited[node] = 1;
        for (int adjNode : adjList.get(node)) {
            if (visited[adjNode] == 0) {
                dfs(adjNode, visited, adjList);
            }
        }
    }

    private void convertToAdjList(int[][] adj, List<List<Integer>> adjList) {

        for (int i = 0; i < adj.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    if (!adjList.get(j).contains(i)) {
                        adjList.get(j).add(i);
                    }
                }
            }
        }
    }

    public int findCircleNum(int[][] adj) {
        List<List<Integer>> adjList = new ArrayList<>();
        convertToAdjList(adj, adjList);

        int[] visited = new int[adj.length];

        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, visited, adjList);
            }
        }

        return count;
    }


}
