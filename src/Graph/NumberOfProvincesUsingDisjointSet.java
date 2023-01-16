package Graph;

import java.util.*;

public class NumberOfProvincesUsingDisjointSet {
    class DisjointSet {
        List<Integer> size, parent;
        public DisjointSet(int v) {
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (parent.get(node) == node)
                return node;

            int parentNode = findParent(parent.get(node));
            parent.set(node, parentNode);
            return parentNode;
        }

        public void unionBySize(int u, int v) {
            int parent_u = parent.get(u);
            int parent_v = parent.get(v);
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

    public int findCircle(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ds.unionBySize(i, j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
