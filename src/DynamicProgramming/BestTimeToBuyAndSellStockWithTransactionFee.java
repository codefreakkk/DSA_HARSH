package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    // memoization
    private int solve(int index, int buy, int fee, int[] nums, int[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];

        if (buy == 1) {
            int pick = -nums[index] + solve(index + 1, 0, fee, nums, dp);
            int notPick = solve(index + 1, 1, fee, nums, dp);
            dp[index][buy] = Math.max(pick, notPick);
        }
        else {
            int pick = (nums[index] - fee) + solve(index + 1, 1, fee, nums, dp);
            int notPick = solve(index + 1, 0, fee, nums, dp);
            dp[index][buy] = Math.max(pick, notPick);
        }
        return dp[index][buy];
    }

    // memoization
    public int maxProfit(int[] nums, int fee) {
        int n = nums.length;

        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 1, fee, nums, dp);
    }

    // tabulation
    public int maxProfitTabulation(int[] nums, int fee) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    int pick = -nums[index] + dp[index + 1][0];
                    int notPick = dp[index + 1][1];
                    dp[index][buy] = Math.max(pick, notPick);
                }
                else {
                    int pick = (nums[index] - fee) + dp[index + 1][1];
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
