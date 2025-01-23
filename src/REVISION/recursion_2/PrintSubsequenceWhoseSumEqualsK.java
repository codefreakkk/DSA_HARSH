package REVISION.recursion_2;
import java.util.*;

public class PrintSubsequenceWhoseSumEqualsK {

    private void solve(int sum, int index, int k, List<Integer> output, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            if (sum == k) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        output.add(nums[index]);
        solve(sum + nums[index], index + 1, k, output, nums, ans);
        output.removeLast();
        solve(sum, index + 1, k, output, nums, ans);
    }

    public List<List<Integer>> subsetSumEqualsK(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, 0, k, new ArrayList<>(), nums, ans);
        return ans;
    }

    public static void main(String[] args) {
        PrintSubsequenceWhoseSumEqualsK o = new PrintSubsequenceWhoseSumEqualsK();
        List<List<Integer>> ans = o.subsetSumEqualsK(new int[]{1, 2, 3, 1, 5}, 3);
        for (List<Integer> it : ans) {
            System.out.println(it);
        }
    }
}
