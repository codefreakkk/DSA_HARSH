package DynamicProgramming;

import java.util.Arrays;

public class _01Knapsack {

    // memoization
    private int solve(int index, int w, int[] wt, int[] val, int[][] dp) {
        if (index == 0) {
            if (wt[0] <= w) return val[0];
            else return 0;
        }
        if (dp[index][w] != -1) return dp[index][w];

        int notPick = 0 + solve(index - 1, w, wt, val, dp);

        int pick = Integer.MIN_VALUE;
        if (wt[index] <= w) {
            pick = val[index] + solve(index - 1, w - wt[index], wt, val, dp);
        }
        return dp[index][w] = Math.max(notPick, pick);
    }

    // memoization
    public int knapSack(int w, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, w, wt, val, dp);
    }

    // tabulation
    public int knapSackTabulation(int w, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][w + 1];
        for (int i = wt[0]; i <= w; i++)
            dp[0][i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int cap = 0; cap <= w; cap++) {
                int notPick = dp[i - 1][cap];

                int pick = Integer.MIN_VALUE;
                if (wt[i] <= cap) {
                    pick = val[i] + dp[i - 1][cap - wt[i]];
                }
                dp[i][cap] = Math.max(notPick, pick);
            }
        }
        return dp[n - 1][w];
    }

    // tabulation + single array space optimization
    public int knapSackSpaceOptimization(int w, int[] wt, int[] val, int n) {
        int[] prev = new int[w + 1];
        for (int i = wt[0]; i <= w; i++)
            prev[i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int cap = w; cap >= 0; cap--) {
                int notPick = prev[cap];

                int pick = Integer.MIN_VALUE;
                if (wt[i] <= cap) {
                    pick = val[i] + prev[cap - wt[i]];
                }
                prev[cap] = Math.max(notPick, pick);
            }
        }
        return prev[w];
    }

    public static void main(String[] args) {
        _01Knapsack o = new _01Knapsack();
        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;
        int n = wt.length;
        System.out.println(o.knapSack(W, wt, val, n));
    }
}
