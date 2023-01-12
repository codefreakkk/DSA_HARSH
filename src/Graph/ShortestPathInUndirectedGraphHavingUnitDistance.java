package Graph;

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
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Pair> queue = new LinkedList<>();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
            distance[i] = (int) 1e9;

        distance[src] = 0;
        queue.offer(new Pair(src, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int current = pair.node;
            int weight = pair.weight;

            for (int adjNode : adj.get(current)) {
                if (1 + weight < distance[adjNode]) {
                    distance[adjNode] = 1 + weight;
                    queue.offer(new Pair(adjNode, 1 + weight));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == 1e9)
                distance[i] = -1;
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
