package Heaps;

import java.util.*;
public class KthLargestSumSubArray {
    // TC - o(n ^ 2), SC = o(n ^ 2)
    // brute force approach
    public static int kthLargestSumSubArray(int[] nums, int k) {
        int size = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }

        Collections.sort(list);
        return list.get(list.size() - k);
    }

    // optimized approach
    public static int kthLargestSumSubArrayOptimized(int[] nums, int k) {
        int size = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            int sum = 0;

            for (int j = i; j < size; j++) {
                sum += nums[j];
                if (pq.size() < k)
                    pq.offer(sum);
                else {
                    if (sum > pq.peek()) {
                        pq.poll();
                        pq.offer(sum);
                    }
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int k = 2;
        System.out.println(kthLargestSumSubArrayOptimized(nums, k));
    }
}
