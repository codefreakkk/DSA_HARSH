package JUST_CODES;
import java.util.*;
public class NumberOfOperationsToMakeNetworkConnected {

    class DisjointSet {
        List<Integer> parent, size;
        public DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (parent.get(node) == node) {
                return node;
            }
            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if (parent_u == parent_v)
                return;

            if (size.get(parent_u) < size.get(parent_v)) {
                parent.set(parent_u, parent_v);
                size.set(parent_v, size.get(parent_u) + size.get(parent_v));
            }
            else {
                parent.set(parent_v, parent_u);
                size.set(parent_u, size.get(parent_u) + size.get(parent_v));
            }
        }
    }

    public int makeConnected(int n, int[][] grid) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdge = 0;

        for (int[] edge : grid) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findParent(u) == ds.findParent(v)) {
                extraEdge++;
            }
            else ds.unionBySize(u, v);
        }

        // count components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.parent.get(i)) {
                components++;
            }
        }
        if (extraEdge >= components - 1)
            return components - 1;

        return -1;
    }

    public static void main(String[] args) {

    }
}
