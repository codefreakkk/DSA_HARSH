package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumEqualsToTarget {

    // memoization
    private boolean solve(int index, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) {
            return nums[index] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        boolean notPick = solve(index - 1, target, nums, dp);
        boolean pick = false;
        if (nums[index] <= target) {
            pick = solve(index - 1, target - nums[index], nums, dp);
        }
        dp[index][target] = (pick || notPick) == true ? 1 : 0;
        return pick || notPick;
    }

    // memoization
    public boolean subsetSum(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, k, nums, dp);
    }


    // tabulation
    public boolean subsetSumTabulation(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k)
            dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (nums[i] <= target) {
                    pick = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = notPick || pick;
            }
        }
        return dp[n - 1][k];
    }
    public static void main(String[] args) {

    }
}
