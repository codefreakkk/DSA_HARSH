package REVISION.GraphAlgos;

import java.util.*;

public class CycleDetectionDirectedGraphBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int adjNode : adj.get(i))
                indegree[adjNode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0)
                    queue.offer(adjNode);
            }
        }
        return !(count == V);
    }

    public static void main(String[] args) {

    }
}
