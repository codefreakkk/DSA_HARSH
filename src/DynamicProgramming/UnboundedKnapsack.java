package DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {

    // memoization
    private int solve(int index, int w, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            return (int) (w / wt[0]) * val[0];
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

    public static void main(String[] args) {

    }
}
