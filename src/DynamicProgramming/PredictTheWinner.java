package DynamicProgramming;

import java.util.Arrays;

public class PredictTheWinner {

    private int solve(int[] nums, int left, int right, int[][] dp) {
        if (left == right) return nums[left];
        if (dp[left][right] != -1) return dp[left][right];

        int l = nums[left] - solve(nums, left + 1, right, dp);
        int r = nums[right] - solve(nums, left, right - 1, dp);

        return dp[left][right] = Math.max(l, r);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = solve(nums, 0, n - 1, dp);
        return ans >= 0 ? true : false;
    }

    public static void main(String[] args) {

    }
}
