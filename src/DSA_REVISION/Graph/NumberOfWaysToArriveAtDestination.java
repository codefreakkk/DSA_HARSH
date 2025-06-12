package DSA_REVISION.Graph;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {

    class Pair {
        int node, distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int distance = edge[2];
            adjList.get(u).add(new Pair(v, distance));
            adjList.get(v).add(new Pair(u, distance));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int currentDistance = current.distance;

            for (Pair adjacentPair : adjList.get(node)) {
                int adjacentNode = adjacentPair.node;
                int adjacentDistance = adjacentPair.distance;
                int totalDistance = currentDistance + adjacentDistance;

                if (totalDistance < distance[adjacentNode]) {
                    distance[adjacentNode] = totalDistance;
                    ways[adjacentNode] = ways[node];
                    queue.offer(new Pair(adjacentNode, totalDistance));
                }
                if (totalDistance == distance[adjacentNode]) {
                    ways[adjacentNode] += ways[node];
                }
            }
        }
        return distance[n - 1];
    }


    public static void main(String[] args) {

    }
}
