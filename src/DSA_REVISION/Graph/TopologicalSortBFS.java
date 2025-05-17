package DSA_REVISION.Graph;

import java.util.*;

public class TopologicalSortBFS {
    /*
     * Topological sort using khans algorithm
     */

    public ArrayList<Integer> topologicalSort(int V, int[][] edges) {
        int n = edges.length;

        // construct graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
        }

        int[] indegree = new int[V];
        for (List<Integer> graph : adjList) {
            for (int edge : graph) {
                indegree[edge]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int adjacentNode : adjList.get(node)) {
                indegree[adjacentNode]--;
                if (indegree[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }
        return ans;
    }
}
