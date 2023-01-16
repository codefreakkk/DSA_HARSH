package Graph;

import java.util.*;

public class KruskalsAlgorithm {
    class Edge implements Comparable<Edge> {
        int weight, u, v;
        public Edge(int weight, int u, int v) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }

        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    public int spanningTree(int V, int E, int[][] edges) {
        List<Edge> list = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            list.add(new Edge(weight, u, v));
        }
        Collections.sort(list);

        DisjointSet ds = new DisjointSet(V);
        int ans = 0;

        for (int i = 0; i < list.size(); i++) {
            int u = list.get(i).u;
            int v = list.get(i).v;
            int weight = list.get(i).weight;

            if (ds.findParent(u) != ds.findParent(v)) {
                ans += weight;
                ds.unionBySize(u, v);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
