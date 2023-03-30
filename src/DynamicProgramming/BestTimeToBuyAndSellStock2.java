package DynamicProgramming;
import java.util.*;

public class BestTimeToBuyAndSellStock2 {

    // memoization
    private int solve(int index, int buy, int[] nums, int[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];

        int profit;
        if (buy == 1) {
            int pick = -nums[index] + solve(index + 1, 0, nums, dp);
            int notPick = solve(index + 1, 1, nums, dp);
            profit = Math.max(pick, notPick);
        }
        else {
            int pick = nums[index] + solve(index + 1, 1, nums, dp);
            int notPick = solve(index + 1, 0, nums, dp);
            profit = Math.max(pick, notPick);
        }
        return dp[index][buy] = profit;
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
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if (buy == 1) {
                    int pick = -nums[index] + dp[index + 1][0];
                    int notPick = 0 + dp[index + 1][1];
                    profit = Math.max(pick, notPick);
                }
                else {
                    int pick = nums[index] + dp[index + 1][1];
                    int notPick = 0 + dp[index + 1][0];
                    profit = Math.max(pick, notPick);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {

    }
}
