package Graph;

import java.util.*;

public class LargestColorValueInDirectedGraph {

    private int dfs(int node, String colors, int[] visited, int[][] count, List<List<Integer>> adjList) {
        if (visited[node] == 0) {
            visited[node] = 1;

            for (int adjacentNode : adjList.get(node)) {
                if (dfs(adjacentNode, colors, visited, count, adjList) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for (int i = 0; i < 26; i++) {
                    int charIndex = colors.charAt(i) - 'a';
                    count[node][charIndex] = Math.max(count[node][charIndex], count[adjacentNode][charIndex]);
                }
            }
            count[node][colors.charAt(node) - 'a']++;
            visited[node] = 2;
        }
        return visited[node] == 2 ? count[node][colors.charAt(node) - 'a'] : Integer.MAX_VALUE;
    }

    public int largestPathValue(String colors, int[][] edges) {
        int V = colors.length();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }

        int[] visited = new int[V];
        int[][] count = new int[V][26];

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < V && ans != Integer.MAX_VALUE; i++) {
            ans = Math.max(ans, dfs(i, colors, visited, count, adjList));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
