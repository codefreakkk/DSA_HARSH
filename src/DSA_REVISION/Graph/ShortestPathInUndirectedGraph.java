package DSA_REVISION.Graph;

import java.util.*;

public class ShortestPathInUndirectedGraph {

    class Pair {
        int node, distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int node = adj.get(i).get(j);
                adjList.get(i).add(node);
                adjList.get(node).add(i);
            }
        }

        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int weight = pair.distance;

            for (int adjacentNode : adjList.get(node)) {
                int totalWeight = weight + 1;
                if (totalWeight < distance[adjacentNode]) {
                    distance[adjacentNode] = totalWeight;
                    queue.offer(new Pair(adjacentNode, distance[adjacentNode]));
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == (int) 1e9) {
                distance[i] = -1;
            }
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
