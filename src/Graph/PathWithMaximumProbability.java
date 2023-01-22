package Graph;

import java.util.*;

public class PathWithMaximumProbability {
    class Pair {
        int node;
        double weight;
        public Pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] p, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, p[i]));
            adj.get(v).add(new Pair(u, p[i]));
        }

        double[] distance = new double[n];
        for (int i = 0; i < n; i++)
            distance[i] = 0.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.weight > a.weight) return 1;
            return -1;
        });

        pq.offer(new Pair(start, (double) 1.0));
        distance[start] = 1.0;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            double weight = pair.weight;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                double adjWeight = current.weight;

                if (weight * adjWeight > distance[adjNode]) {
                    distance[adjNode] = weight * adjWeight;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        if (distance[end] != 0.0)
            return distance[end];

        return 0;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };
        double[] p = {0.5, 0.5, 0.3};
        PathWithMaximumProbability o = new PathWithMaximumProbability();
        System.out.println(o.maxProbability(edges.length, edges, p, 0, 2));
    }
}
