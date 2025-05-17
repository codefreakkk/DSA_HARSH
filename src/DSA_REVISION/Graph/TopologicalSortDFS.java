package DSA_REVISION.Graph;

import java.util.*;

public class TopologicalSortDFS {

    public void dfs(int node, List<List<Integer>> adjList, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (int adjacentNode : adjList.get(node)) {
            if (visited[adjacentNode] == 0) {
                dfs(adjacentNode, adjList, stack, visited);
            }
        }
        stack.push(node);
    }

    public ArrayList<Integer> topologicalSort(int V, int[][] edges) {
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
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adjList, stack, visited);
            }
        }

        // prepare ans
        ArrayList<Integer> ans = new ArrayList<>();
        for (int it : stack) {
            ans.add(it);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
