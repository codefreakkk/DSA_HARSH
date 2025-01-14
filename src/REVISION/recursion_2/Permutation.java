package REVISION.recursion_2;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void solve(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            solve(index + 1, nums, ans);

            // backtrack
            swap(i, index, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
