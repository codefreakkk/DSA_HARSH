package REVISION.GraphAlgos;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    class Pair {
        int node, distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(u, w));
            adj.get(v).add(new Pair(v, w));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        int[] parent = new int[n + 1];
        parent[1] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.distance;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjDistance = current.distance;

                if (adjDistance + dist < distance[adjNode]) {
                    parent[adjNode] = node;
                    distance[adjNode] = adjDistance + dist;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
