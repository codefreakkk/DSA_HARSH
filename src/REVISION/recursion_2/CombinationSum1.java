package REVISION.recursion_2;
import java.util.*;

public class CombinationSum1 {

    private void solve(int index, int target, List<Integer> output, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length || target == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        if (target >= nums[index]) {
            output.add(nums[index]);
            solve(index, target - nums[index], output, nums, ans);
            output.removeLast();
        }
        solve(index + 1, target, output, nums, ans);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, new ArrayList<>(), nums, ans);
        return ans;
    }


    public static void main(String[] args) {

    }

}
