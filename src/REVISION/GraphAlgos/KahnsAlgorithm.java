package REVISION.GraphAlgos;

import java.util.*;

public class KahnsAlgorithm {

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        int[] ans = new int[V];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int adjNode : adj.get(i))
                indegree[adjNode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0)
                    queue.offer(adjNode);
            }
        }
        for (int i = 0; i < V; i++)
            ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {

    }
}
