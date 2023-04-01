package DynamicProgramming;
import java.util.*;

public class BestTimeToBuyAndSellStock3 {

    // memoization
    private int solve(int index, int buy, int cap, int[] nums, int[][][] dp) {
        if (cap == 0 || index == nums.length) return 0;
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }

        int profit = 0;
        if (buy == 1) {
            int pick = -nums[index] + solve(index + 1, 0, cap, nums, dp);
            int notPick = solve(index + 1, 1, cap, nums, dp);
            profit = Math.max(pick, notPick);
        }
        else {
            int pick = nums[index] + solve(index + 1, 1, cap - 1, nums, dp);
            int notPick = solve(index + 1, 0, cap, nums, dp);
            profit = Math.max(pick, notPick);
        }
        return dp[index][buy][cap] = profit;
    }

    // memoization
    public int maxProfit(int[] nums) {
        int n = nums.length;

        int[][][] dp = new int[n + 1][2][3];
        for (int[][] rows : dp) {
            for (int[] row : rows) Arrays.fill(row, -1);
        }

        return solve(0, 1, 2, nums, dp);
    }

    // tabulation
    public int maxProfitTabulation(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][2][3];

        // base case 1
        for (int index = 0; index <= n; index++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[index][buy][0] = 0;
            }
        }

        // base case 2
        for (int buy = 0; buy < 2; buy++) {
            for (int cap = 0; cap < 3; cap++) {
                dp[n][buy][cap] = 0;
            }
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if (buy == 1) {
                        int pick = -nums[index] + dp[index + 1][0][cap];
                        int notPick = dp[index + 1][1][cap];
                        dp[index][buy][cap] = Math.max(pick, notPick);
                    } else {
                        int pick = nums[index] + dp[index + 1][1][cap - 1];
                        int notPick = dp[index + 1][0][cap];
                        dp[index][buy][cap] = Math.max(pick, notPick);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    public static void main(String[] args) {

    }
}
