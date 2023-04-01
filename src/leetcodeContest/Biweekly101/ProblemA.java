package leetcodeContest.Biweekly101;

import java.util.*;

public class ProblemA {

    public static int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i : nums1) set.add(i);
        for (int i : nums2) {
            if (set.contains(i)) return i;
        }
        int num1 = Math.min(nums1[0], nums2[0]);
        int num2 = Math.max(nums1[0], nums2[0]);
        return num1 * 10 + num2;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 5, 2, 6};
        int[] nums2 = {3, 1, 7};
        System.out.println(minNumber(nums1, nums2));
    }
}
