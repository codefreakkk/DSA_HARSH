package Graph;

import java.util.Arrays;

public class NegativeCycleInDirectedGraph {
    public int isNegativeWeightCycle(int n, int[][] edges)  {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // bellmanford algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                int totalDistance = distance[u] + weight;
                if (distance[u] != Integer.MAX_VALUE && totalDistance < distance[v])
                    distance[v] = totalDistance;
            }
        }

        // detect cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            int totalDistance = distance[u] + weight;
            if (distance[u] != (int) 1e9 && totalDistance < distance[v])
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
