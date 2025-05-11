package DSA_REVISION.Graph;

import java.util.*;

public class DetectCycleInUndirectedGraphBFS {

    class Pair {
        int node, parent;
        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private boolean detectCycle(int vertex, int[][] edges, int[] visited) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited[vertex] = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, -1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int parent = pair.parent;

            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == 1 && adjNode != parent) {
                    return true;
                }
                visited[adjNode] = 1;
                queue.offer(new Pair(adjNode, node));
            }
        }
        return false;
    }

    public boolean isCycle(int vertex, int[][] edges) {
        int[] visited = new int[vertex];

        for (int i = 0; i < vertex; i++) {
            if (visited[i] == 0) {
                if (detectCycle(i, edges, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

}
