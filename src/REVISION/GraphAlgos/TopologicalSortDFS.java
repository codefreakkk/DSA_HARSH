package REVISION.GraphAlgos;

import java.util.*;

public class TopologicalSortDFS {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0)
                dfs(adjNode, adj, stack, visited);
        }
        stack.push(node);
    }

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0)
                dfs(i, adj, stack, visited);
        }
        int[] ans = new int[V];
        for (int i = 0; i < V; i++)
            ans[i] = stack.pop();

        return ans;
    }

    public static void main(String[] args) {

    }
}
