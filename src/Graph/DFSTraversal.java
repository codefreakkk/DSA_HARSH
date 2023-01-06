package Graph;

import java.util.*;

public class DFSTraversal {

    public void solve(int node, ArrayList<ArrayList<Integer>>adj, ArrayList<Integer> ans, int[] visited) {
        visited[node] = 1;
        ans.add(node);

        for (int i : adj.get(node)) {
            if (visited[i] != 1)
                solve(i, adj, ans, visited);
        }
    }

    // for 1 based indexing
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v + 1];
        int startingIndex = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        solve(startingIndex, adj, ans, visited);
        return ans;
    }

    public void adjacencyList(int n, int m, ArrayList<ArrayList<Integer>> adj) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());


        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public static void main(String[] args) {
        DFSTraversal o = new DFSTraversal();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 2;
        int m = 1;
        o.adjacencyList(n, m, adj);
        ArrayList<Integer> ans = o.dfsOfGraph(n, adj);
        System.out.println(ans);
    }
}
