package REVISION.GraphAlgos;

import java.util.*;

public class DFSTraversal {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int[] visited) {
        visited[node] = 1;
        ans.add(node);

        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0)
                dfs(adjNode, adj, ans, visited);
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        dfs(0, adj, ans, visited);
        return ans;
    }

    public static void main(String[] args) {

    }
}
