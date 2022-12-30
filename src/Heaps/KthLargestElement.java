package Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        int size = nums.length;
        for (int i = k; i < size; i++) {
            int current = nums[i];
            if (current > pq.peek()) {
                pq.poll();
                pq.offer(current);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargestElement(nums, k));
    }
}
