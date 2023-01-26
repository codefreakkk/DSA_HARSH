package REVISION.GraphAlgos;

import java.util.*;

public class PrimsAlgorithm {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int spanningTree(int V, int E, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] visited = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(0, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            if (visited[node] == 1)
                continue;

            sum += weight;
            visited[node] = 1;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjWeight = current.weight;

                if (visited[adjNode] == 0)
                    pq.offer(new Pair(adjNode, adjWeight));
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
