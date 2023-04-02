package DynamicProgramming;
import java.util.*;

public class LongestIncreasingSubsequence {

    // memoization
    private int solve(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][prev + 1] != -1) return dp[index][prev + 1];

        int notPick = solve(index + 1, prev, nums, dp);

        int pick = Integer.MIN_VALUE;
        if (prev == -1 || nums[index] > nums[prev]) {
            pick = 1 + solve(index + 1, index, nums, dp);
        }
        return dp[index][prev + 1] = Math.max(notPick, pick);
    }

    // memoization
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, -1, nums, dp);
    }

    public static void main(String[] args) {

    }
}
