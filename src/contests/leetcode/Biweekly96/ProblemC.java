package contests.leetcode.Biweekly96;

import java.util.*;

// problem not completed
public class ProblemC {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;

        int addition = 0, temp = k;
        for (int i = n - 1; i >= 0; i--) {
            addition += nums1[i];
            temp--;
            if (temp <= 0) break;
        }

        int min = Integer.MAX_VALUE;
        temp = k;
        for (int i = n - 1; i >= k; i--) {
            min = Math.min(nums2[i], min);
            temp--;
            if (temp <= 0) break;
        }

        System.out.println(addition);

        return addition * min;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));
    }
}
