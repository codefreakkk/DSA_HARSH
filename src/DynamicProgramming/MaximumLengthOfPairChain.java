package DynamicProgramming;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    private int solve(int index, int prev, int[][] pairs, int[][] dp) {
        if (index >= pairs.length) return 0;

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        int pick = 0, notPick;
        if (prev == -1 || pairs[prev][1] < pairs[index][0]) {
            pick = 1 + solve(index + 1, index, pairs, dp);
        }
        notPick = solve(index + 1, prev, pairs, dp);
        return dp[index][prev + 1] = Math.max(pick, notPick);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int n = pairs.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        return solve(0, -1, pairs, dp);
    }

    public static void main(String[] args) {

    }
}
