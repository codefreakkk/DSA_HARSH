package Graph;

import java.util.*;

public class BellmanfordAlgorithm {
    public int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int src) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e8);
        distance[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : adj) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (distance[u] != (int) 1e8 && distance[u] + weight < distance[v])
                    distance[v] = distance[u] + weight;
            }
        }

        // detect negative cycle
        for (ArrayList<Integer> edge : adj) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            if (distance[u] != 1e8 && distance[u] + weight < distance[v])
                return new int[]{-1};
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
