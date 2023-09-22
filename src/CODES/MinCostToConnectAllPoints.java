package CODES;
import java.util.*;

public class MinCostToConnectAllPoints {

    class Pair {
        int weight, node;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private int manhattanDistance(int[] nums1, int[] nums2) {
        return Math.abs(nums1[0] - nums2[0]) + Math.abs(nums1[1] - nums2[1]);
    }

    public int minCostToConnectPoints(int[][] points) {
        int n = points.length;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = manhattanDistance(points[i], points[j]);
                adj.get(i).add(new Pair(j, weight));
            }
        }

        int[] visited = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(0, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            if (visited[node] == 1) {
                continue;
            }
            sum += weight;
            visited[node] = 1;

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int adjWeight = p.weight;

                if (visited[adjNode] == 0) {
                    pq.offer(new Pair(adjNode, adjWeight));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
