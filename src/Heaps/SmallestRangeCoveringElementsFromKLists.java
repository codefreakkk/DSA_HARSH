package Heaps;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
    class Tupple {
        int data, i, j;
        public Tupple(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Tupple> pq = new PriorityQueue<>(new Comparator<Tupple>() {
            @Override
            public int compare(Tupple t1, Tupple t2) {
                return t1.data - t2.data;
            }
        });


        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int k = nums.size();

        // store element in minheap
        for (int i = 0; i < k; i++) {
            int current = nums.get(i).get(0);
            max = Math.max(max, current);
            pq.offer(new Tupple(current, i, 0));
        }

        int start = pq.peek().data, end = max;
        while (!pq.isEmpty()) {
            Tupple top = pq.poll();
            min = top.data;

            // update ans
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // update max
            int i = top.i, j = top.j;
            if (j + 1 < nums.get(i).size()) {
                int current = nums.get(i).get(j + 1);
                max = Math.max(current, max);
                pq.offer(new Tupple(current, i, j + 1));
            }
            else
                break;
        }
        return new int[] {start, end};
    }

    public static void main(String[] args) {

    }
}
