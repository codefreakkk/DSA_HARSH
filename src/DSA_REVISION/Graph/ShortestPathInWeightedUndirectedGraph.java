package DSA_REVISION.Graph;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {

    class Pair {
        int node, distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int distance = edges[i][2];
            adjList.get(u).add(new Pair(v, distance));
            adjList.get(v).add(new Pair(u, distance));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, (int) 1e9);
        distance[1] = 0;

        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int currentDistance = pair.distance;

            for (Pair adjacentPair : adjList.get(node)) {
                int adjacentNode = adjacentPair.node;
                int adjacentDistance = adjacentPair.distance;
                int totalWeight = currentDistance + adjacentDistance;

                if (totalWeight < distance[adjacentNode]) {
                    distance[adjacentNode] = totalWeight;
                    parent[adjacentNode] = node;
                    pq.offer(new Pair(adjacentNode, totalWeight));
                }
            }
        }

        if (distance[n] == (int) 1e9) {
            return List.of(-1);
        }

        int node = n;
        List<Integer> ans = new ArrayList<>();
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
