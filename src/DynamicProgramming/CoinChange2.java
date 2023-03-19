package DynamicProgramming;

import java.util.Arrays;

public class CoinChange2 {

    // memoization
    private int solve(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];

        int notPick = solve(index - 1, target, coins, dp);

        int pick = 0;
        if (coins[index] <= target) {
            pick = solve(index, target - coins[index], coins, dp);
        }
        return dp[index][target] = notPick + pick;
    }

    // memoization
    public int coinChange(int[] coins, int target) {
        int n = coins.length;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, target, coins, dp);
    }


    // tabulation
    public int coinChangeTabulation(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];

        // base case
        for (int i = 0; i <= target; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notPick = dp[i - 1][t];

                int pick = 0;
                if (coins[i] <= t) {
                    pick = dp[i][t - coins[i]];
                }
                dp[i][t] = notPick + pick;
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {

    }
}
