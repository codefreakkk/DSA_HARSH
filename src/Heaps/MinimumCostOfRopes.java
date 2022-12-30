package Heaps;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    public static long minCost(long[] nums) {
        int size = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++)
            pq.offer(nums[i]);

        long ans = 0;
        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long addition = num1 + num2;
            ans += addition;
            pq.offer(addition);
        }
        return ans;
    }

    public static void main(String[] args) {
        long arr[] = {4, 3, 2, 6};
        System.out.println(minCost(arr));
    }
}
