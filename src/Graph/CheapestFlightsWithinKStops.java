package Graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    class Tupple {
        int stop, node, distance;
        public Tupple(int stop, int node, int distance) {
            this.stop = stop;
            this.node = node;
            this.distance = distance;
        }
    }

    public void convertIntoGraph(int n, ArrayList<ArrayList<Pair>> adj, int[][] flights) {
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
        }
    }

    public int cheapestFlights(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        convertIntoGraph(n, adj, flights);

        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
            distance[i] = (int) 1e9;

        distance[src] = 0;

        Queue<Tupple> queue = new LinkedList<>();
        queue.offer(new Tupple(0, src, 0));

        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int stop = tupple.stop;
            int node = tupple.node;
            int dist = tupple.distance;

            if (stop > k)
                continue;

            for (Pair pair : adj.get(node)) {
                int adjNode = pair.node;
                int weight = pair.weight;

                if (weight + dist < distance[adjNode])
                {
                    distance[adjNode] = weight + dist;
                    queue.offer(new Tupple(stop + 1, adjNode, distance[adjNode]));
                }
            }
        }

        if (distance[dst] == (int) 1e9)
            return -1;

        return distance[dst];
    }

    public static void main(String[] args) {

    }
}
