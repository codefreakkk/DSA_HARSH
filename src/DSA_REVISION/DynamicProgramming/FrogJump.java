package DSA_REVISION.DynamicProgramming;

import java.util.*;

public class FrogJump {

    private int solve(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int left = solve(index - 1, nums, dp) + Math.abs(nums[index] - nums[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = solve(index - 2, nums, dp) + Math.abs(nums[index] - nums[index - 2]);
        }

        return dp[index] = Math.min(left, right);
    }

    public int tabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 1; i <= n - 1; i++) {
            int left = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(nums[i] - nums[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n - 1];
    }

    public int minCost(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n, nums, dp);
    }
}
