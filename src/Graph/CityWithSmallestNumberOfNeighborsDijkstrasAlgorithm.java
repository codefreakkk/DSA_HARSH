package Graph;

import java.util.*;

public class CityWithSmallestNumberOfNeighborsDijkstrasAlgorithm {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstras(int src, int n, ArrayList<ArrayList<Pair>> adj) {
        int[] distance = new int[n];
        int max = (int) 1e9;
        for (int i = 0; i < n; i++)
            distance[i] = max;

        distance[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.weight;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjDist = current.weight;

                if (adjDist + dist < distance[adjNode]) {
                    distance[adjNode] = adjDist + dist;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        return distance;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }

        int cityCount = n, city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int[] distance = dijkstras(i, n, adj);

            for (int num : distance) {
                if (num <= distanceThreshold)
                    count++;
            }
            if (count <= cityCount) {
                cityCount = count;
                city = i;
            }
        }
        return city;
    }

    public static void main(String[] args) {

    }
}
