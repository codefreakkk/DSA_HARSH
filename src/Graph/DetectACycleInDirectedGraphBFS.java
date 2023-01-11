package Graph;

import java.util.*;

public class DetectACycleInDirectedGraphBFS {
    public boolean detectCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjacentNode : adj.get(i))
                indegree[adjacentNode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int adjacentNode : adj.get(node)) {
                indegree[adjacentNode]--;
                if (indegree[adjacentNode] == 0)
                    queue.offer(adjacentNode);
            }
        }
        return !(count == v);
    }

    public static void main(String[] args) {

    }
}
