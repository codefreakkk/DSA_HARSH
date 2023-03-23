package leetcodeContest.Biweekly96;

import java.util.*;

public class ProblemA {
    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1)
            set.add(i);

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]))
                return nums2[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        System.out.println(getCommon(nums1, nums2));
    }
}
