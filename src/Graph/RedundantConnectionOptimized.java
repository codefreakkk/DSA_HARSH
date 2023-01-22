package Graph;

import java.util.*;

public class RedundantConnectionOptimized {
    class DisjointSet {
        public List<Integer> size, parent;
        public DisjointSet(int v) {
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
                return node;

            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if (parent_u == parent_v)
                return;

            if (size.get(parent_v) < size.get(parent_u)) {
                parent.set(parent_v, parent_u);
                size.set(parent_u, size.get(parent_u) + size.get(parent_v));
            }
            else {
                parent.set(parent_u, parent_v);
                size.set(parent_v, size.get(parent_u) + size.get(parent_v));
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[2];

        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (ds.findParent(u) != ds.findParent(v))
                ds.unionBySize(u, v);
            else {
                ans[0] = u;
                ans[1] = v;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
