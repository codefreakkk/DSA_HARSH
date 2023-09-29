package CODES;
import java.util.*;

public class MinCostToConnectAllPoints {

    class Edge {
        int source, destination, distance;
        public Edge(int source, int destination, int distance) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
        }

    }

    class DSU {
        List<Integer> parent, size;
        public DSU(int n) {
            this.parent = new ArrayList<>();
            this.size = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
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

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);

            if (parent_u == parent_v) {
                return;
            }
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

    private int manhattanDistance(int[] nums1, int[] nums2) {
        return Math.abs(nums1[0] - nums2[0]) + Math.abs(nums1[1] - nums2[1]);
    }

    public int minCostToConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = this.manhattanDistance(points[i], points[j]);
                adj.add(new Edge(i, j, distance));
            }
        }
        Collections.sort(adj, (a, b) -> a.distance - b.distance);
        DSU o = new DSU(n);

        int sum = 0;
        for (Edge edge : adj) {
            int source = edge.source;
            int destination = edge.destination;
            int distance = edge.distance;

            if (o.findParent(source) != o.findParent(destination)) {
                sum += distance;
                o.unionBySize(source, destination);
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
