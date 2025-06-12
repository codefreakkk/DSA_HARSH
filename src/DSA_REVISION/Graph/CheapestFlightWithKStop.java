package DSA_REVISION.Graph;

import java.util.*;

public class CheapestFlightWithKStop {

    class Pair {
        int node, distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    class Tupple {
        int node, stops, distance;
        public Tupple(int stops, int node, int distance) {
            this.stops = stops;
            this.distance = distance;
            this.node = node;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dist, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int distance = edge[2];

            adjList.get(u).add(new Pair(v, distance));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        Queue<Tupple> queue = new LinkedList<>();
        queue.offer(new Tupple(0, src, 0));

        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int stops = tupple.stops;
            int node = tupple.node;
            int currentDistance = tupple.distance;

            if (stops > k) continue;
            for (Pair adjacentPair : adjList.get(node)) {
                int adjacentNode = adjacentPair.node;
                int adjacentDistance = adjacentPair.distance;
                int totalDistance = currentDistance + adjacentDistance;

                if (totalDistance < distance[adjacentNode]) {
                    distance[adjacentNode] = totalDistance;
                    queue.offer(new Tupple(stops + 1, adjacentNode, totalDistance));
                }
            }
        }
        return distance[dist];
    }

    public static void main(String[] args) {

    }
}
