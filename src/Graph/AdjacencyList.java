package Graph;

import java.util.*;

public class AdjacencyList {

    public void adjacencyList(int n, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        print(adj);
    }

    public void print(List<List<Integer>> adj) {
        for (List<Integer> list : adj)
            System.out.println(list);
    }

    public static void main(String[] args) {
        AdjacencyList o = new AdjacencyList();
        int n = 2, m = 1;
        o.adjacencyList(n, m);
    }
}
