package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {

    // memoization
    private int solve(int index, int target, int[] coin, int[][] dp) {
        if (index == 0) {
            if (target % coin[0] == 0) {
                return target / coin[0];
            }
            return (int) 1e9;
        }
        if (dp[index][target] != -1) return dp[index][target];

        int notPick = solve(index - 1, target, coin, dp);

        int pick = 0;
        if (coin[index] <= target) {
            pick = 1 + solve(index - 1, target - coin[index], coin, dp);
        }
        return Math.min(notPick, pick);
    }

    // memoization
    public int coinChange(int[] coin, int target) {
        int n = coin.length;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, target, coin, dp);
    }

    // tabulation
    public int coinChangeTabulation(int[] coin, int target) {
        int n = coin.length;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i <= target; i++) {
            if (i % coin[0] == 0) {
                dp[0][i] = i / coin[0];
            }
            else dp[0][i] = (int) 1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                int notPick = dp[i - 1][t];

                int pick = (int) 1e9;
                if (coin[i] <= t) {
                    pick = 1 + dp[i][t - coin[i]];
                }
                dp[i][t] = Math.min(notPick, pick);
            }
        }
        int ans = dp[n - 1][target];
        if (ans == (int) 1e9) return -1;
        return ans;
    }

    public static void main(String[] args) {

    }
}
