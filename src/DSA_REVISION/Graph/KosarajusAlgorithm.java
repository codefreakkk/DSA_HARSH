package DSA_REVISION.Graph;

import java.util.*;

public class KosarajusAlgorithm {

    private void topologicalSort(int node, int[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = 1;
        for (int adjacentNode : adjList.get(node)) {
            if (visited[adjacentNode] == 0) {
                topologicalSort(adjacentNode, visited, stack, adjList);
            }
        }
        stack.push(node);
    }

    private void dfs(int node, int[] visited, List<List<Integer>> adjList) {
        visited[node] = 1;
        for (int adjacentNode : adjList.get(node)) {
            if (visited[adjacentNode] == 0) {
                dfs(adjacentNode, visited, adjList);
            }
        }
    }

    public int kosarajusAlgorithm(ArrayList<ArrayList<Integer>> adjList) {
        int V = adjList.size();

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];

        // toposort
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topologicalSort(i, visited, stack, adjList);
            }
        }

        // reverse graph
        List<List<Integer>> adjListReversed = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjListReversed.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            visited[i] = 0;
            for (int node : adjList.get(i)) {
                adjListReversed.get(node).add(i);
            }
        }

        // compute ans
        int count = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == 0) {
                count++;
                dfs(node, visited, adjListReversed);
            }
        }
        return count;
    }
}
