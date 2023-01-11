package Graph;

import java.util.*;

public class TopologicalSortDFS {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;

        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0)
                dfs(adjacentNode, adj, stack, visited);
        }
        stack.push(node);
    }

    public int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0)
                dfs(i, adj, stack, visited);
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++)
            ans[i] = stack.pop();

        return ans;
    }

    public static void main(String[] args) {

    }
}
