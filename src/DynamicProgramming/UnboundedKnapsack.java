package DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {

    // memoization
    private int solve(int index, int w, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            return (w / wt[0]) * val[0];
        }
        if (dp[index][w] != -1) return dp[index][w];

        int notPick = solve(index - 1, w, wt, val, dp);

        int pick = Integer.MIN_VALUE;
        if (wt[index] <= w) {
            pick = val[index] + solve(index, w - wt[index], wt, val, dp);
        }
        return dp[index][w] = Math.max(notPick, pick);
    }

    // memoization
    public int knapSack(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, w, wt, val, dp);
    }

    // tabulation
    public int knapSackTabulation(int n, int w, int[] wt, int[] val) {
        int[][] dp = new int[n][w + 1];
        for (int i = wt[0]; i <= w; i++)
            dp[0][i] = (i / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= w; t++) {
                int notPick = dp[i - 1][t];

                int pick = Integer.MIN_VALUE;
                if (wt[i] <= t) {
                    pick = val[i] + dp[i][t - wt[i]];
                }
                dp[i][t] = Math.max(notPick, pick);
            }
        }
        return dp[n - 1][w];
    }


    // tabulation + 1D array space optimization - SC - o(W)
    public int knapSackTabulationSpaceOptimization(int n, int w, int[] wt, int[] val) {
        int[] dp = new int[w + 1];
        for (int i = wt[0]; i <= w; i++)
            dp[i] = (i / wt[0]) * val[0];

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= w; t++) {
                int notPick = dp[t];

                int pick = Integer.MIN_VALUE;
                if (wt[i] <= t) {
                    pick = val[i] + dp[t - wt[i]];
                }
                dp[t] = Math.max(notPick, pick);
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {}
}
