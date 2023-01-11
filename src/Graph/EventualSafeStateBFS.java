package Graph;

import java.util.*;

public class EventualSafeStateBFS {
    public List<Integer> eventualSafeState(int v, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adjRev.add(new ArrayList<>());

        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int adjacentNode : adj.get(i)) {
                adjRev.get(adjacentNode).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int adjacentNode : adjRev.get(node)) {
                indegree[adjacentNode]--;
                if (indegree[adjacentNode] == 0)
                    queue.offer(adjacentNode);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
