package Graph;

import java.util.*;

public class BipartiteGraph {
    public boolean detectBipartite(int node, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int adjacentNode : adj.get(current)) {
                if (color[adjacentNode] == -1) {
                    color[adjacentNode] = 1 - color[current];
                    queue.offer(adjacentNode);
                }
                else if (color[current] == color[adjacentNode])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[v];
        for (int i = 0; i < v; i++)
            color[i] = -1;

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (detectBipartite(i, color, adj) == false)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
