package Graph;

import java.util.*;

public class KosarajusAlgorithm {
    public void sort(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0)
                sort(adjNode, adj, stack, visited);
        }
        stack.push(node);
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0)
                dfs(adjNode, adj, visited);
        }
    }

    public int kosarajus(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];

        // store edges according to finish time
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0)
                sort(i, adj, stack, visited);
        }

        // reverse edges
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjRev.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            visited[i] = 0;
            for (int edge : adj.get(i))
                adjRev.get(edge).add(i);
        }

        // dfs
        int strongComponents = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == 0) {
                strongComponents++;
                dfs(node, adjRev, visited);
            }
        }
        return strongComponents;
    }

    public static void main(String[] args) {

    }
}
