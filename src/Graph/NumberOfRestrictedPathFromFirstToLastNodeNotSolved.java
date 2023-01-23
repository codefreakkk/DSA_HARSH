package Graph;

// not solved requires dp
import java.util.*;

public class NumberOfRestrictedPathFromFirstToLastNodeNotSolved {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private int ans = 0;
    private void dfs(int node, List<List<Pair>> adj, int[] distance, int[] visited) {
        if (node == 1) {
            ans++;
            return;
        }
        visited[node] = 1;
        for (Pair current : adj.get(node)) {
            int adjNode = current.node;
            if (visited[adjNode] == 0 && distance[adjNode] > distance[node])
            {
                dfs(adjNode, adj, distance, visited);
                visited[adjNode] = 0;
            }
        }
    }

    public int restrictedPaths(int n, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] distance = new int[n + 1];
        for (int i = 0; i <= n; i++)
            distance[i] = (int) 1e9;

        distance[n] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(n, 0));

        // find distance using dijkstars
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjWeight = current.weight;

                if (weight + adjWeight < distance[adjNode]) {
                    distance[adjNode] = weight + adjWeight;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        // dfs
        int[] visited = new int[n + 1];
        dfs(n, adj, distance, visited);
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {1, 3, 3},
                {2, 3, 1},
                {1, 4, 2},
                {5, 2, 2},
                {3, 5, 1},
                {5, 4, 10}
        };
        NumberOfRestrictedPathFromFirstToLastNodeNotSolved o = new NumberOfRestrictedPathFromFirstToLastNodeNotSolved();
        System.out.println(o.restrictedPaths(5, nums));
    }
}
