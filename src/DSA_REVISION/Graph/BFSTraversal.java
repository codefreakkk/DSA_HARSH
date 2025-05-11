package DSA_REVISION.Graph;

import java.util.*;

public class BFSTraversal {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[adj.size()];
        visited[0] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int adjNode : adj.get(node)) {
                if (visited[adjNode] == 0) {
                    queue.offer(adjNode);
                    visited[adjNode] = 1;
                }
            }
        }
        return ans;
    }
}
