package POTD_LEETCODE;

import java.util.*;

public class MaximumSubsequenceScore {

    class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }

        // sort array in reverse order
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);

        long ans = 0, sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums[i][0], nums[i][1]));
            sum += nums[i][0];

            if (pq.size() == k) {
                Pair element = pq.poll();
                ans = Math.max(ans, sum * element.second);
                sum -= element.first;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSubsequenceScore o = new MaximumSubsequenceScore();
        int[] nums1 = {4,2,3,1,1};
        int[] nums2 = {7,5,10,9,6};
        int k = 1;
        System.out.println(o.maxScore(nums1, nums2, k));
    }
}
