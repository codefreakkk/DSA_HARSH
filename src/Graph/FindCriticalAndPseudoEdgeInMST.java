package Graph;

import java.util.*;

public class FindCriticalAndPseudoEdgeInMST {
    class DisjointSet {
        List<Integer> parent, size;
        public DisjointSet(int n) {
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
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
        public void union(int u, int v) {
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

    public int getMst(int n, int[][] edges, int blockedEdge, int preEdge) {
        DisjointSet ds = new DisjointSet(n);
        int weight = 0;

        if (preEdge != -1) {
            weight += edges[preEdge][2];
            ds.union(edges[preEdge][0], edges[preEdge][1]);
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == blockedEdge) continue;
            if (ds.findParent(edges[i][0]) != ds.findParent(edges[i][1])) {
                weight += edges[i][2];
                ds.union(edges[i][0], edges[i][1]);
            }
        }

        // if graph get divided into multiple parts then critical edge is present
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) != ds.findParent(0))
                return (int) (1e9 + 7);
        }
        return weight;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] grid) {
        int size = grid.length;
        int[][] edges = new int[size][4];

        for (int i = 0; i < size; i++) {
            edges[i][0] = grid[i][0];
            edges[i][1] = grid[i][1];
            edges[i][2] = grid[i][2];
            edges[i][3] = i;
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int originalMst = this.getMst(n, edges, -1, -1);
        List<Integer> critical = new ArrayList<>();
        List<Integer> notCritical = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (originalMst < this.getMst(n, edges, i, -1)) {
                critical.add(edges[i][3]);
            }
            else if (originalMst == this.getMst(n, edges, -1, i)) {
                notCritical.add(edges[i][3]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(notCritical);
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 1},{1, 2, 1},{0,2,1},{2, 3, 4},{3, 4, 2},{3, 5, 2}, {4, 5, 2}
        };
        FindCriticalAndPseudoEdgeInMST o = new FindCriticalAndPseudoEdgeInMST();
        System.out.println(o.findCriticalAndPseudoCriticalEdges(6, edges));
    }
}
