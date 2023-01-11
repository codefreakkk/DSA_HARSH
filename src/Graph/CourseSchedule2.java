package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public void convertIntoGraph(int v, int[][] prerequisite, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : prerequisite) {
            int u = edge[0];
            int vv = edge[1];
            adj.get(u).add(vv);
        }
    }

    public int[] findOrder(int v, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        convertIntoGraph(v, prerequisites, adj);

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

        if (list.size() != v)
            return new int[]{};

        int[] ans = new int[v];
        for (int i = 0; i < v; i++)
            ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {

    }
}
