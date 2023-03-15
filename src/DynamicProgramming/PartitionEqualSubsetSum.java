package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    // memoization
    private boolean solve(int index, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) {
            return nums[0] == target;
        }
        if (dp[index][target] != -1) return dp[index][target] == 1 ? true : false;

        boolean notPick = solve(index - 1, target, nums, dp);
        boolean pick = false;
        if (nums[index] <= target) {
            pick = solve(index - 1, target - nums[index], nums, dp);
        }
        dp[index][target] = (pick || notPick) == true ? 1 : 0;
        return pick || notPick;
    }

    // memoization
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, target, nums, dp);
    }

    // tabulation
    public boolean canPartitionTabulation(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        int k = sum / 2;

        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (nums[0] <= k) dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (nums[i] <= target) {
                    pick = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = pick || notPick;
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {}
}
