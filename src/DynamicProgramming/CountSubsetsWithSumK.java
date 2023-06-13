package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetsWithSumK {

    // memoization
    private int solve(int index, int target, int[] nums, int[][] dp) {
        if (index == 0) {
            // edge case if subset contains 0
            if (target == 0 && nums[0] == target) return 2;

            else if (target == 0 || nums[0] == target) return 1;
            else return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];

        int notPick = solve(index - 1, target, nums, dp);
        int pick = 0;
        if (nums[index] <= target) {
            pick = solve(index - 1, target - nums[index], nums, dp);
        }
        return dp[index][target] = notPick + pick;
    }

    // memoization
    public int countSubsets(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, k, nums, dp);
    }

    // tabulation
    public int countSubsetsTabulation(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= k) dp[0][nums[0]] = 1;
        if (nums[0] == 0) dp[0][0] = 2;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                int notPick = dp[i - 1][target];

                int pick = 0;
                if (nums[i] <= target)
                    pick = dp[i - 1][target - nums[i]];

                dp[i][target] = (notPick + pick);
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {

    }
}
