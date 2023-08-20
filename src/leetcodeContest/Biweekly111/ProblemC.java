package leetcodeContest.Biweekly111;
import java.util.*;

public class ProblemC {

    private int getLISCount(int index, int prev, List<Integer> nums, int[][] dp) {
        if (index == nums.size()) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        int notPick = getLISCount(index + 1, prev, nums, dp);

        int pick = 0;
        if (prev == -1 || nums.get(index) >= nums.get(prev)) {
            pick = 1 + getLISCount(index + 1, index, nums, dp);
        }
        return dp[index][prev + 1] = Math.max(pick, notPick);
    }

    public int minimumOperation(List<Integer> nums) {
        int n = nums.size();

        int[][] dp = new int[n + 1][n + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        int lisCount = getLISCount(0, -1, nums, dp);
        return n - lisCount;
    }

    public static void main(String[] args) {
        ProblemC o = new ProblemC();
        List<Integer> nums = List.of(2,1,3,2,1);
        System.out.println(o.minimumOperation(nums));
    }
}
