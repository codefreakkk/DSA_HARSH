package POTD_LEETCODE;
import java.util.*;

public class FindTheDifferenceOfTwoArrays {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int val : nums2) set1.add(val);

        List<Integer> temp1 = new ArrayList<>();
        for (int val : nums1) {
            if (!set1.contains(val)) {
                temp1.add(val);
                set1.add(val);
            }
        }

        Set<Integer> set2 = new HashSet<>();
        for (int val : nums1) set2.add(val);

        List<Integer> temp2 = new ArrayList<>();
        for (int val : nums2) {
            if (!set2.contains(val)) {
                temp2.add(val);
                set2.add(val);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(temp1);
        ans.add(temp2);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        System.out.println(findDifference(nums1, nums2));
    }
}
