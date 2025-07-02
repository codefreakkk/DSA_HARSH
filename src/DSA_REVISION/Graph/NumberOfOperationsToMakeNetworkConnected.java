package DSA_REVISION.Graph;

public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);

        ds = new DisjointSet(n);
        int edgesCount = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (ds.findParent(u) != ds.findParent(v)) {
                ds.unionBySize(u, v);
            } else {
                edgesCount++;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.findParent(i)) {
                count++;
            }
        }
        if (edgesCount >= count - 1) {
            return count - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
