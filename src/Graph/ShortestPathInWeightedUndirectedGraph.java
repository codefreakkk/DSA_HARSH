package Graph;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    class Pair {
        int node, distance;
        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public void convertIntoGraph(int n, int[][] edges, ArrayList<ArrayList<Pair>> adj) {
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(weight, v));
            adj.get(v).add(new Pair(weight, u));
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        convertIntoGraph(n, edges, adj);

        int[] parent = new int[n + 1];
        int[] distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = (int) 1e9;
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        distance[1] = 0;
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int dist = pair.distance;

            for (Pair current : adj.get(node)) {
                int weight = current.distance;
                int adjNode = current.node;
                int totalDistance = weight + dist;

                if (totalDistance < distance[adjNode]) {
                    distance[adjNode] = totalDistance;
                    parent[adjNode] = node;
                    pq.offer(new Pair(totalDistance, adjNode));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (distance[n] == 1e9) {
            ans.add(-1);
            return ans;
        }

        // backtrack in parent array
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
