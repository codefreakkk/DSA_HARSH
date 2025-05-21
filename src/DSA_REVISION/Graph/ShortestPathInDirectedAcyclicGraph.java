package DSA_REVISION.Graph;

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {

    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private void topoSort(int node, List<List<Pair>> adjList, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (Pair pair : adjList.get(node)) {
            int adjacentNode = pair.node;
            if (visited[adjacentNode] == 0) {
                topoSort(adjacentNode, adjList, stack, visited);
            }
        }
        stack.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adjList.get(u).add(new Pair(v, weight));
        }

        // find topological sort
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topoSort(i, adjList, stack, visited);
            }
        }

        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;

        // relax the edges
        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (Pair pair : adjList.get(node)) {
                int adjacentNode = pair.node;
                int adjacentNodeWeight = pair.weight;

                int totalWeight = distance[node] + adjacentNodeWeight;
                if (totalWeight < distance[adjacentNode]) {
                    distance[adjacentNode] = totalWeight;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (distance[i] == (int) 1e9) {
                distance[i] = -1;
            }
        }
        return distance;
    }
}
