package RANDOM_PROBLEM;
import java.util.*;

public class ServersTime {

    public static int[] minTimeToReachEnd(int[] nums) {
        int n = nums.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int leftIndex = i - nums[i];
            int rightIndex = i + nums[i];

            if (leftIndex >= 0) {
                adj.get(leftIndex).add(i);
            }
            if (rightIndex < n) {
                adj.get(rightIndex).add(i);
            }
        }

        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[n - 1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n - 1);
        distance[n - 1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adjNode : adj.get(node)) {
                if (distance[adjNode] == -1) {
                    distance[adjNode] = 1 + distance[node];
                    queue.offer(adjNode);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 3, 4};
        int[] ans = minTimeToReachEnd(nums);
        System.out.println(Arrays.toString(ans));
    }
}
