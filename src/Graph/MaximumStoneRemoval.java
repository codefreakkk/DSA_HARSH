package Graph;

import java.util.*;

public class MaximumStoneRemoval {
    class DisjointSet {
        List<Integer> parent, size;
        public DisjointSet(int v) {
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
                return node;

            int parentNode = findParent(parent.get(node));
            parent.set(node, parentNode);
            return parentNode;
        }

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if (parent_u == parent_v)
                return;

            if (size.get(parent_v) < size.get(parent_u)) {
                parent.set(parent_v, parent_u);
                size.set(parent_u, size.get(parent_v) + size.get(parent_u));
            }
            else {
                parent.set(parent_u, parent_v);
                size.set(parent_v, size.get(parent_u) + size.get(parent_v));
            }
        }
    }

    public int maxRemove(int[][] stones, int n) {
        int row = 0, col = 0;
        for (int[] edge : stones) {
            int u = edge[0];
            int v = edge[1];
            row = Math.max(row, u);
            col = Math.max(col, v);
        }

        DisjointSet ds = new DisjointSet(row + col + 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + row + 1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }

        int nodesCount = 0;
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (mp.getKey() == ds.findParent(mp.getKey()))
                nodesCount++;
        }
        return n - nodesCount;
    }

    public static void main(String[] args) {
        int[][] nodes = {
                {0, 0},
                {0, 2},
                {1, 3},
                {3, 0},
                {3, 2},
                {4, 3}
        };
        MaximumStoneRemoval o = new MaximumStoneRemoval();
        System.out.println(o.maxRemove(nodes, nodes.length));
    }
}
