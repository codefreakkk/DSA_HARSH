package Heaps;

import java.util.PriorityQueue;

public class KthLargestElementInStreamLeetcode {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargestElementInStreamLeetcode(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for (int i : nums) {
            pq.offer(i);

            if (pq.size() > k)
                pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k)
            pq.poll();

        return pq.peek();
    }

    public static void main(String[] args) {

    }
}
