package DSA_REVISION.heaps;

import java.util.*;

public class KthLargestSumContiguousSubarray {

    public int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (pq.size() < k) {
                    pq.offer(sum);
                } else {
                    if (sum > pq.peek()) {
                        pq.poll();
                        pq.offer(sum);
                    }
                }
            }
        }
        return pq.peek();
    }

}
