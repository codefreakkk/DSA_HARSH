package DSA_REVISION.Graph;

import java.util.*;

public class FindEventualSafeState {

    private boolean dfs(int node, List<List<Integer>> adjList, int[] visited, int[] pathVisited, int[] count) {
        visited[node] = 1;
        pathVisited[node] = 1;
        count[node] = 0;

        for (int adjacentNode : adjList.get(node)) {
            if (visited[adjacentNode] == 0) {
                if (dfs(adjacentNode, adjList, visited, pathVisited, count)) {
                    count[node] = 0;
                    return true;
                }
            } else if (pathVisited[adjacentNode] == 1) {
                count[node] = 0;
                return true;
            }
        }

        pathVisited[node] = 0;
        count[node] = 1;
        return false;
    }

    public List<Integer> eventualSafeState(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, adjList, visited, pathVisited, count);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }


}
