package Graph;

import java.util.ArrayList;

public class BipartiteGraphDFS {
    public boolean detectBipartite(int node, int newColor, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = newColor;
        for (int adjacentNode : adj.get(node)) {
            if (color[adjacentNode] == -1) {
                if (detectBipartite(adjacentNode, 1 - newColor, color, adj) == false)
                    return false;
            }
            else if (color[adjacentNode] == newColor)
                return false;
        }
        return true;
    }

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[v];
        for (int i = 0; i < v; i++)
            color[i] = -1;

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (detectBipartite(i, 0, color, adj) == false)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
