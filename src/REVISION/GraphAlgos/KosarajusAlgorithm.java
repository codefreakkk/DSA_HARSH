package REVISION.GraphAlgos;

import java.util.*;

public class KosarajusAlgorithm{
    public void topo(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0)
                topo(adjNode, adj, visited, stack);
        }
        stack.push(node);
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adjRev, int[] visited) {
        visited[node] = 1;
        for (int adjNode : adjRev.get(node)) {
            if (visited[adjNode] == 0)
                dfs(adjNode, adjRev, visited);
        }
    }

    public int kosarajus(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];

        // toposort
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topo(i, adj, visited, stack);
            }
        }

        // reverse the edges
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
            visited[i] = 0;
        }

        for (int i = 0; i <V; i++) {
            for (int edge : adj.get(i))
                adjRev.get(edge).add(i);
        }

        // dfs
        int strongComponent = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited[node] == 0) {
                strongComponent++;
                dfs(node, adjRev, visited);
            }
        }
        return strongComponent;
    }

    public static void main(String[] args) {

    }
}
