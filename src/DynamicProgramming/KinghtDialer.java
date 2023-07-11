package DynamicProgramming;

import java.util.Arrays;

public class KinghtDialer {

    private int MOD = (int) 1e9+7;

    private boolean check(int row, int col) {
        return row < 0 || row >= 4 || col < 0 || col >= 3 || (row == 3 && col != 1);
    }

    // TABULATION NOT WORKING

//    public long tabulation(int n) {
//        long[][][] dp = new long[4][3][n + 1];
//
//        // base case
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                dp[i][j][1] = 1;
//            }
//        }
//
//        for (int i = 3; i >= 0; i--) {
//            for (int j = 2; j >= 0; j--) {
//                for (int nn = 2; nn <= n; nn++) {
//                    long upLeft = check(i - 2, j - 1) ? 0 : dp[i - 2][j - 1][n - 1];
//                    long upRight = check(i - 2, j + 1) ? 0 : dp[i - 2][j + 1][n - 1];
//                    long downLeft = check(i + 2, j - 1) ? 0 : dp[i + 2][j - 1][n - 1];
//                    long downRight = check(i + 2, j + 1) ? 0 : dp[i + 2][j + 1][n - 1];
//                    long leftUp = check(i - 1, j - 2) ? 0 : dp[i - 1][j - 2][n - 1];
//                    long leftDown = check(i + 1, j - 2) ? 0 : dp[i + 1][j - 2][n - 1];
//                    long rightUp = check(i - 1, j + 2) ? 0 : dp[i - 1][j + 2][n - 1];
//                    long rightDown = check(i + 1, j + 2) ? 0 : dp[i + 1][j + 2][n - 1];
//                    dp[i][j][n] = upLeft + upRight + downLeft + downRight + leftUp + leftDown + rightUp + rightDown;
//                }
//            }
//        }
//        for (long[][] d : dp) {
//            for (long[] k : d) {
//                System.out.println(Arrays.toString(k));
//            }
//        }
//        return dp[3][2][n];
//    }

    private long solve(int row, int col, int n, long[][][] dp) {
        if (check(row, col)) {
            return 0;
        }
        if (n == 1) return 1;

        if (dp[row][col][n] > 0) return  dp[row][col][n];

        long upLeft = solve(row - 2, col - 1, n - 1, dp) % MOD;
        long upRight = solve(row - 2, col + 1, n - 1, dp) % MOD;
        long downLeft = solve(row + 2, col - 1, n - 1, dp) % MOD;
        long downRight = solve(row + 2, col + 1, n - 1, dp) % MOD;
        long leftUp = solve(row - 1, col - 2, n - 1, dp) % MOD;
        long leftDown = solve(row + 1, col - 2, n - 1, dp) % MOD;
        long rightUp = solve(row - 1, col + 2, n - 1, dp) % MOD;
        long rightDown = solve(row + 1, col + 2, n - 1, dp) % MOD;

        dp[row][col][n] = upLeft + upRight + downLeft + downRight + leftUp + leftDown + rightUp + rightDown;
        return dp[row][col][n];
    }

    public int knightDialer(int n) {
        if (n == 1) return 10;

        long dp[][][] = new long[4][3][n + 1];
        long ans = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + solve(i, j, n, dp)) % MOD;
            }
        }
        return (int) ans;
    }



    public static void main(String[] args) {
        KinghtDialer o = new KinghtDialer();
        int n = 2;
//        System.out.println(o.tabulation(n));
    }
}
