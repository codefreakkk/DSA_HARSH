package REVISION.GraphAlgos;

import java.util.*;

public class BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int [] visited = new int[V];
        visited[0] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == 0) {
                    visited[adjNode] = 1;
                    queue.offer(adjNode);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
