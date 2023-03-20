package DynamicProgramming;

import java.util.Arrays;

public class RodCuttingProblem {

    // memoization
    private int solve(int index, int N, int[] price, int[][] dp) {
        if (index == 0) {
            return price[0] * N;
        }
        if (dp[index][N] != -1) return dp[index][N];

        int notPick = solve(index - 1, N, price, dp);

        int pick = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= N) {
            pick = price[index] + solve(index, N - rodLength, price, dp);
        }
        return dp[index][N] = Math.max(notPick, pick);
    }

    // memoization
    public int rodCutting(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, n, price, dp);
    }

    // tabulation
    public int rodCuttingTabulation(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i <= n; i++)
            dp[0][i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= n; t++) {
                int notPick = dp[i - 1][t];

                int pick = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if (rodLength <= t) {
                    pick = price[i] + dp[i][t - rodLength];
                }
                dp[i][t] = Math.max(notPick, pick);
            }
        }
        return dp[n - 1][n];
    }

    // tabulation + single array Space optimization
    public int rodCuttingTabulationSpaceOptimization(int[] price, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dp[i] = i * price[0];

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= n; t++) {
                int notPick = dp[t];

                int pick = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if (rodLength <= t) {
                    pick = price[i] + dp[t - rodLength];
                }
                dp[t] = Math.max(notPick, pick);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
