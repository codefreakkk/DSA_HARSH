package DSA_REVISION.heaps;

import java.util.*;

public class SmallestRangeCoveringElementsFromKList {

    class Pair {
        int num, row, col;
        public Pair(int num, int row, int col) {
            this.num = num;
            this.row = row;
            this.col = col;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = nums.get(i).get(0);
            pq.offer(new Pair(num, i, 0));

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int start = min, end = max;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            min = pair.num;
            int row = pair.row, col = pair.col;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (col + 1 < nums.get(row).size()) {
                int num = nums.get(row).get(col + 1);
                max = Math.max(max, num);
                pq.offer(new Pair(num, row, col + 1));
            } else {
                break;
            }
        }
        return new int[]{start, end};
    }
}
