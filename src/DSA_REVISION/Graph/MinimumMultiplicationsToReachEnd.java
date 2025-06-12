package DSA_REVISION.Graph;

import java.util.*;

public class MinimumMultiplicationsToReachEnd {

    class Pair {
        int node, steps;
        public Pair(int node, int steps) {
            this.node = node;
            this.steps = steps;
        }
    }

    public int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;

        int mod = 100000;
        int[] distance = new int[99999];
        Arrays.fill(distance, (int) 1e9);
        distance[start] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int steps = pair.steps;

            for (int it : arr) {
                int num = (node * it ) % mod;
                if (num == end) {
                    return steps + 1;
                }

                if (steps + 1 < distance[num]) {
                    distance[num] = steps + 1;
                    queue.offer(new Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
