package REVISION.GraphAlgos;

import java.util.*;

public class CycleDetectionUndirectedGraphBFS {
    class Pair {
        int node, parent;
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    public boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, -1));
        visited[src] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int parent = pair.parent;

            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == 0) {
                    visited[adjNode] = 1;
                    queue.offer(new Pair(adjNode, node));
                }
                else if (adjNode != parent)
                    return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, adj, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
