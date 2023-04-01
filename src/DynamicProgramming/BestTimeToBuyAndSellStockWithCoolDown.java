package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCoolDown {

    // memoization
    private int solve(int index, int buy, int[] nums, int[][] dp) {
        if (index >= nums.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];

        if (buy == 1) {
            int pick = -nums[index] + solve(index + 1, 0, nums, dp);
            int notPick = solve(index + 1, 1, nums, dp);
            dp[index][buy] = Math.max(pick, notPick);
        }
        else {
            int pick = nums[index] + solve(index + 2, 1, nums, dp);
            int notPick = solve(index + 1, 0, nums, dp);
            dp[index][buy] = Math.max(pick, notPick);
        }
        return dp[index][buy];
    }

    // memoization
    public int maxProfit(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 1, nums, dp);
    }

    // tabulation
    public int maxProfitTabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int pick = -nums[index] + dp[index + 1][0];
                    int notPick = dp[index + 1][1];
                    dp[index][buy] = Math.max(pick, notPick);
                }
                else {
                    int pick = nums[index] + dp[index + 2][1];
                    int notPick = dp[index + 1][0];
                    dp[index][buy] = Math.max(pick, notPick);
                }
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {

    }
}
