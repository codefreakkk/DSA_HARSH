package contests.leetcode.Biweekly96;

import java.util.Arrays;

public class ProblemB {
    public static int minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0)
            return Arrays.equals(nums1, nums2) ? 0 : -1;

        int n = nums1.length, count = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0)
                return -1;

            if (diff > 0)
                count += diff / k;

            ans += diff;
        }
        return ans == 0 ? count : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {15,31,20,3,28,19};
        int[] nums2 = {36,31,14,0,34,1};
        int k = 3;
        System.out.println(minOperations(nums1, nums2, k));
    }
}
