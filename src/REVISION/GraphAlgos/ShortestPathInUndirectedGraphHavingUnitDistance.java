package REVISION.GraphAlgos;

import java.util.*;

public class ShortestPathInUndirectedGraphHavingUnitDistance {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] distance = new int[n];
        int max = (int) 1e9;
        for (int i = 0; i < n; i++) {
            distance[i] = max;
        }
        distance[src] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int weight = pair.weight;

            for (int adjNode : adj.get(node)) {
                if (weight + 1 < distance[adjNode]) {
                    distance[adjNode] = weight + 1;
                    queue.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == max)
                distance[i] = -1;
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
