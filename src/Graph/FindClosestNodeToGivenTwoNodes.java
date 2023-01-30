package Graph;

import java.util.*;

public class FindClosestNodeToGivenTwoNodes {
    private void findPath(int node, int[] path, int[] edges, int distance) {
        if (node != -1 && path[node] == -1) {
            path[node] = distance;
            findPath(edges[node], path, edges, distance + 1);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] path1 = new int[n];
        Arrays.fill(path1, -1);

        int[] path2 = new int[n];
        Arrays.fill(path2, -1);

        findPath(node1, path1, edges, 0);
        findPath(node2, path2, edges, 0);

        int minDistance = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < n; i++) {
            if (Math.min(path1[i], path2[i]) >= 0 && Math.max(path1[i], path2[i]) < minDistance)
            {
                minDistance = Math.max(path1[i], path2[i]);
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
