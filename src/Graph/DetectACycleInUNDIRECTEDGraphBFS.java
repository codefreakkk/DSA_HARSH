package Graph;

import java.util.*;

public class DetectACycleInUNDIRECTEDGraphBFS {
    class Pair {
        int data, parent;
        public Pair(int data, int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, -1));
        visited[src] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.data;
            int parent = pair.parent;

            for (int adjacentNode : adj.get(node)) {
                if (visited[adjacentNode] == 0) {
                    visited[adjacentNode] = 1;
                    queue.offer(new Pair(adjacentNode, node));
                }
                else if (adjacentNode != parent)
                    return true;
            }
        }
        return false;
    }

    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
