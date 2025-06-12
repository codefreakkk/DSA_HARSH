package DSA_REVISION.Graph;

import java.util.*;
public class BellmanFordAlgorithm {

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] distance = new int[V];

        int MAX_DISTANCE = (int) 1e8;
        Arrays.fill(distance, MAX_DISTANCE);

        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (distance[u] != MAX_DISTANCE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        // check for negative cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (distance[u] !=  MAX_DISTANCE && distance[u] + wt < distance[v]) {
                return new int[]{-1};
            }
        }
        return distance;
    }


    public static void main(String[] args) {

    }
}
