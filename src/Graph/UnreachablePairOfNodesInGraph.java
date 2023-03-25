package Graph;
import java.util.*;

public class UnreachablePairOfNodesInGraph {

    private int dfs(int node, List<List<Integer>> adj, int[] visited) {
        visited[node] = 1;
        int count = 1;
        for (int adjNode : adj.get(node)) {
            if (visited[adjNode] == 0) {
                count += dfs(adjNode, adj, visited);
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visited = new int[n];
        int sum = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                int size = dfs(i, adj, visited);
                ans += sum * size;
                sum += size;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UnreachablePairOfNodesInGraph o = new UnreachablePairOfNodesInGraph();
        int[][] edge = {
                {0, 2},{0, 5},{2, 4},{1, 6},{5, 4}
        };
        int n = 7;
        System.out.println(o.countPairs(n, edge));
    }
}
