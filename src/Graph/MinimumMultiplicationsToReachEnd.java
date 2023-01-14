package Graph;

import java.util.*;

public class MinimumMultiplicationsToReachEnd {
    class Pair {
        int node, distance;
        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int minimumMultiplication(int[] nums, int start, int end) {
        int size = nums.length;
        int[] distance = new int[(int)1e5];
        for (int i = 0; i < 1e5; i++)
            distance[i] = -1;
        distance[start] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int dist = pair.distance;

            for (int i = 0; i < size; i++) {
                int product = (node * nums[i]) % (int) 1e5;
                if (dist + 1 < distance[product]) {
                    distance[product] = dist + 1;
                    queue.offer(new Pair(product, dist + 1));
                }
            }
        }
        if (distance[end] == (int) 1e5)
            return -1;

        return distance[end];
    }

    public static void main(String[] args) {

    }
}
