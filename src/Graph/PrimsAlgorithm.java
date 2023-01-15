package Graph;

import java.util.*;

public class PrimsAlgorithm {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int spanningTree(int v, int e, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int vv = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(vv, weight));
            adj.get(vv).add(new Pair(u, weight));
        }

        int[] visited = new int[v];
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
