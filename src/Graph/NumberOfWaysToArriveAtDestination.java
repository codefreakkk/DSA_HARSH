package Graph;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] grid) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : grid) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] ways = new int[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++)
            distance[i] = Integer.MAX_VALUE;

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(0, 0));

        int mod = 1000000000+7;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjWeight = current.weight;

                if (adjWeight + weight < distance[adjNode]) {
                    distance[adjNode] = adjWeight + weight;
                    ways[adjNode] = ways[node];
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
                else if (adjWeight + weight == distance[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {

    }
}
