package DSA_REVISION.heaps;

import java.util.*;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int it : nums) {
            pq.offer(it);
        }

        int element = 0;
        while (!pq.isEmpty() && k > 0) {
            element = pq.poll();
            k--;
        }
        return element;
    }

}
