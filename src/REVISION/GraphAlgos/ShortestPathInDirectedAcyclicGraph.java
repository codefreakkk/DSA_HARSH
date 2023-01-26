package REVISION.GraphAlgos;
import java.util.*;
public class ShortestPathInDirectedAcyclicGraph {

    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public void topoSort(int node, List<List<Pair>> adj, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;

        for (Pair pair : adj.get(node)) {
            int adjNode = pair.node;
            if (visited[adjNode] == 0)
                topoSort(adjNode, adj, stack, visited);
        }
        stack.push(node);
    }
    public int[] shortestPath(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
        }

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                topoSort(i, adj, stack, visited);
        }

        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = (int) 1e9;
        }
        distance[0] = 0;


        while (!stack.isEmpty()) {
            int node = stack.pop();
            int weight = distance[node];

            for (Pair pair : adj.get(node)) {
                int adjNode = pair.node;
                int adjWeight = pair.weight;
                distance[adjNode] = Math.min(weight + adjWeight, distance[adjNode]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == (int) 1e9)
                distance[i] = -1;
        }

        return distance;
    }


    public static void main(String[] args) {

    }
}
