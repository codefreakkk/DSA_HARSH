package REVISION.GraphAlgos;

import java.util.*;

public class BellmanFord {
    public int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        int[] distance = new int[V];
        int max = (int) 1e8;

        Arrays.fill(distance, max);
        distance[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : adj) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (distance[u] != max && distance[u] + weight < distance[v])
                {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for (ArrayList<Integer> edge : adj) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if (distance[u] != max && distance[u] + weight < distance[v])
                return new int[]{-1};
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
