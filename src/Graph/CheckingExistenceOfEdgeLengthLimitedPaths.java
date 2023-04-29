package Graph;

import java.util.Arrays;
import java.util.*;

public class CheckingExistenceOfEdgeLengthLimitedPaths {

    class DisjointSet {
        List<Integer> parent, size;
        public DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for (int i = 0; i <= n; i++) parent.add(i);
            for (int i = 0; i <= n; i++) size.add(1);
        }

        public int findParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
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

    public boolean[] distanceLimitedPathExist(int n, int[][] edgeList, int[][] q) {
        int[][] queries = new int[q.length][4];
        for (int i = 0; i < q.length; i++) {
            queries[i][0] = q[i][0];
            queries[i][1] = q[i][1];
            queries[i][2] = q[i][2];
            queries[i][3] = i;
        }

        // sort edgeList and queries
        Arrays.sort(edgeList, (a, b) -> {
            return a[2] - b[2];
        });
        Arrays.sort(queries, (a, b) -> {
            return a[2] - b[2];
        });

        DisjointSet ds = new DisjointSet(n);
        boolean[] ans = new boolean[queries.length];

        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            while (j < edgeList.length && edgeList[j][2] < queries[i][2]) {
                ds.unionBySize(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            if (ds.findParent(queries[i][0]) == ds.findParent(queries[i][1])) {
                ans[queries[i][3]] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
