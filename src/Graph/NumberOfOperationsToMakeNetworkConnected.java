package Graph;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnected {

    class DisjointSet {
        List<Integer> size, parent;
        public DisjointSet(int V) {
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();

            for (int i = 0; i < V; i++) {
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

    public int makeConnected(int V, int[][] edges) {
        DisjointSet ds = new DisjointSet(V);

        int extraEdges= 0;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (ds.findParent(u) == ds.findParent(v))
                extraEdges++;
            else
                ds.unionBySize(u, v);
        }

        int components = 0;
        for (int i = 0; i < V; i++) {
            if (i == ds.parent.get(i))
                components++;
        }
        if (extraEdges >= components - 1)
            return components - 1;

        return -1;
    }

    public static void main(String[] args) {
        int[][] edge = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        NumberOfOperationsToMakeNetworkConnected o = new NumberOfOperationsToMakeNetworkConnected();
        System.out.println(o.makeConnected(4, edge));
    }
}
