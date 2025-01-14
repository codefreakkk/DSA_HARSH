package REVISION.recursion_2;

import java.util.*;

public class LinearSearch {

    private static List<Integer> solve(int index, int target, int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (index == nums.length) {
            return list;
        }

        if (nums[index] == target) {
            list.add(index);
        }
        list.addAll(solve(index + 1, target, nums));
        return list;
    }

    private static List<Integer> solve(int index, int target, int[] nums, List<Integer> ans) {
        if (index == nums.length) {
            return ans;
        }
        if (nums[index] == target) {
            ans.add(index);
        }
        return solve(index + 1, target, nums, ans);
    }

    public static List<Integer> search(int target, int[] nums) {
        List<Integer> ans = new ArrayList<>();
        return solve(0, target, nums, ans);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 2, 5, 1};
        List<Integer> ans = LinearSearch.search(2, nums);
        System.out.println(ans);
    }

}
