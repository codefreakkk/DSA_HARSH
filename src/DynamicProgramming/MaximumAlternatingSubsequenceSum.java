package DynamicProgramming;
import java.util.*;

public class MaximumAlternatingSubsequenceSum {


    // memoization
    private long solve(int index, int flag, int[] nums, long[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][flag] != -1) {
            return dp[index][flag];
        }

        long max = 0;
        if (flag == 0) {
            long notPick = solve(index + 1, flag, nums, dp);
            long pick = nums[index] + solve(index + 1, 1, nums, dp);
            max = Math.max(pick, notPick);
        }
        else {
            long notPick = solve(index + 1, flag, nums, dp);
            long pick = -nums[index] + solve(index + 1, 0, nums, dp);
            max = Math.max(pick, notPick);
        }
        return dp[index][flag] = max;
    }

    // memoization
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[][] dp = new long[n + 1][n + 1];
        for (long[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        return solve(0, 0, nums, dp);
    }

    // tabulation
    public long tabulation(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int flag = 0; flag <= 1; flag++) {

                long max = 0;
                if (flag == 0) {
                    long notPick = dp[index + 1][flag];
                    long pick = nums[index] + dp[index + 1][1];
                    max = Math.max(notPick, pick);
                }
                else {
                    long notPick = dp[index + 1][flag];
                    long pick = -nums[index] + dp[index + 1][0];
                    max = Math.max(notPick, pick);
                }
                dp[index][flag] = max;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        MaximumAlternatingSubsequenceSum o = new MaximumAlternatingSubsequenceSum();
        int[] nums = {6,2,1,2,4,5};
        System.out.println(o.tabulation(nums));
    }
}
