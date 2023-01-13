package Graph;

import java.util.*;

public class DijkstraAlgorithm {
    class Pair {
        int node, distance;
        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public int[] dijkstraAlgorithm(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] distance = new int[v];
        for (int i = 0; i < v; i++)
            distance[i] = (int) 1e9;

        distance[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
        pq.offer(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.distance;

            for (ArrayList<Integer> current : adj.get(node)) {
                int newDistance = current.get(1) + dist;
                int adjacentNode = current.get(0);

                if (newDistance < distance[adjacentNode]) {
                    distance[adjacentNode] = newDistance;
                    pq.offer(new Pair(newDistance, adjacentNode));
                }
            }
        }

        for (int i = 0; i < v; i++) {
            if (distance[i] == 1e9)
                distance[i] = -1;
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
