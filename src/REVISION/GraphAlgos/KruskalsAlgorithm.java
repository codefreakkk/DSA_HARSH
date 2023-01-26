package REVISION.GraphAlgos;

import java.util.*;

public class KruskalsAlgorithm {
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
            if (parent.get(node) == node)
                return node;

            int ultimateParent = findParent(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if (parent_u == parent_v) return;
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


    class Edge implements Comparable<Edge> {
        int u, v, weight;
        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    public int spanningTree(int V, int E, int[][] edges) {
        List<Edge> list = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            list.add(new Edge(u, v, w));
        }
        Collections.sort(list);

        DisjointSet ds = new DisjointSet(V);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int u = list.get(i).u;
            int v = list.get(i).v;
            int weight = list.get(i).weight;

            if (ds.findParent(u) != ds.findParent(v)) {
                sum += weight;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
