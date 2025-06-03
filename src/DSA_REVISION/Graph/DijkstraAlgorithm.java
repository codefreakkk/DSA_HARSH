package DSA_REVISION.Graph;

import java.util.*;

public class DijkstraAlgorithm {

    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adjList.get(u).add(new Pair(v, weight));
            adjList.get(v).add(new Pair(u, weight));
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int currentWeight = pair.weight;

            for (Pair adjacentPair : adjList.get(node)) {
                int adjacentNode = adjacentPair.node;
                int adjacentWeight = adjacentPair.weight;
                int totalWeight = currentWeight + adjacentWeight;

                if (totalWeight < distance[adjacentNode]) {
                    distance[adjacentNode] = totalWeight;
                    pq.offer(new Pair(adjacentNode, totalWeight));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
