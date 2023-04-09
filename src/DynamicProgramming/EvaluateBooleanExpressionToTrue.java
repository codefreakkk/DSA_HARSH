package DynamicProgramming;

import java.util.Arrays;

public class EvaluateBooleanExpressionToTrue {

    private int mod = 1003;

    private int solve(int i, int j, int isTrue, String s, int[][][] dp) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            }
            else return s.charAt(i) == 'F' ? 1 : 0;
        }
        if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

        int ways = 0;
        for (int index = i + 1; index <= j - 1; index = index + 2) {
            int LT = solve(i, index - 1, 1, s, dp) % mod;
            int LF = solve(i, index - 1, 0, s, dp) % mod;
            int RT = solve(index + 1, j, 1, s, dp) % mod;
            int RF = solve(index + 1, j, 0, s, dp) % mod;

            if (s.charAt(index) == '&') {
                if (isTrue == 1) {
                    ways += (LT * RT) % mod;
                }
                else {
                    ways += ((LT * RF) % mod + (LF * RT) % mod +
                            (LF * RF) % mod ) % mod;
                }
            }
            else if (s.charAt(index) == '|') {
                if (isTrue == 1) {
                    ways += ((LT * RF) % mod + (LF * RT) % mod +
                            (LT * RT) % mod) % mod;
                }
                else {
                    ways += (LF * RF) % mod;
                }
            }
            else if (s.charAt(index) == '^'){
                if (isTrue == 1) {
                    ways += ((LT * RF) % mod + (LF * RT) % mod) % mod;
                }
                else {
                    ways += ((LT * RT) % mod + (LF * RF) % mod) % mod;
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }

    public int countWays(String s) {
        int n = s.length();

        int[][][] dp = new int[n + 1][n +1][2];
        for (int[][] rows : dp) {
            for (int[] row : rows) Arrays.fill(row, -1);
        }

        return solve(0, n - 1, 1, s, dp);
    }


    public static void main(String[] args) {

    }
}
