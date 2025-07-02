package DSA_REVISION.Graph;

import java.util.*;

public class KurskalAlgorithm {
    public static int kruskalMST(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(V);

        int sum = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (ds.findParent(u) != ds.findParent(v)) {
                sum += w;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
}
