package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyMatrix {

    public void adjacencyMatrix(int n, int m) {
        int[][] adj = new int[n + 1][n + 1];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        this.print(adj);
    }

    public void print(int[][] adj) {
        for (int[] i : adj) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix adj = new AdjacencyMatrix();
        int n = 2;
        int m = 1;
        adj.adjacencyMatrix(n, m);
    }
}
