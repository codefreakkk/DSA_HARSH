package Heaps;

import java.util.*;

public class KthLargestElementInStreamGFG {
    public static int[] kthLargestElement(int k, int[] nums, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[n];

        for (int i = 0; i < k - 1; i++) {
            ans[i] = -1;
            pq.offer(nums[i]);
        }
        pq.offer(nums[k - 1]);
        ans[k - 1] = pq.peek();

        for (int i = k; i < n; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
            ans[i] = pq.peek();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4};
        int k = 1;
        int[] ans = kthLargestElement(k, nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }
}
