package DSA_REVISION.Graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adjacentNode : adjList.get(node)) {
                indegree[adjacentNode]--;
                if (indegree[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
