package Graph;

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public void convertIntoGraph(int n, int m, int[][] edges, ArrayList<ArrayList<Pair>> adj) {
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
        }
    }

    public void topologicalSort(int node, Stack<Integer> stack, int[] visited, ArrayList<ArrayList<Pair>> adj) {
        visited[node] = 1;

        for (Pair adjacentNode : adj.get(node)) {
            if (visited[adjacentNode.node] == 0)
                topologicalSort(adjacentNode.node, stack, visited, adj);
        }
        stack.push(node);
    }

    public int[] shortestPathInDirectedGraph(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        convertIntoGraph(n, m, edges, adj);

        // find topological sort
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                topologicalSort(i, stack, visited, adj);
        }

        // relax the edges
        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
            distance[i] = (int) 1e9;

        distance[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            int nodeDistance = distance[node];

            for (Pair adjacentNode : adj.get(node)) {
                int weight = adjacentNode.weight;
                int adjNode = adjacentNode.node;
                int adjacentNodeDistance =	weight + nodeDistance;
                distance[adjNode] = Math.min(adjacentNodeDistance, distance[adjNode]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == 1e9)
                distance[i] = -1;
        }
        return distance;
    }

    public static void main(String[] args) {

    }
}
