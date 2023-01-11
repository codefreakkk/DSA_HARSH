package Graph;

import java.util.*;

// Kahn's algorithm for topological sort using BFS
public class KahnsAlgorithm {
    public int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            for (int adjacentNode : adj.get(i))
                indegree[adjacentNode]++;
        }

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);

            for (int adjacentNode : adj.get(node)) {
                indegree[adjacentNode]--;

                if (indegree[adjacentNode] == 0)
                    queue.offer(adjacentNode);
            }
        }

        int[] ans = new int[v];
        for (int i = 0; i < v; i++)
            ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {

    }
}
