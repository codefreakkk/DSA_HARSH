package DynamicProgramming;
import java.util.*;

public class RegularExpressionMatching {

    // memoization
    private boolean solve(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {
            while (j >= 0) {
                if (p.charAt(j) == '*') j -= 2;
                else return false;
            }
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            boolean flag = solve(i - 1, j - 1, s, p, dp);
            dp[i][j] = flag ? 1 : 0;
            return flag;
        }

        if (p.charAt(j) == '*') {
            if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                boolean flag = solve(i, j - 2, s, p, dp);
                dp[i][j] = flag ? 1 : 0;
                return flag;
            }
            else {
                boolean left = solve(i - 1, j, s, p, dp);
                boolean right = solve(i, j - 2, s, p, dp);
                dp[i][j] = left || right ? 1 : 0;
                return left || right;
            }
        }
        dp[i][j] = 0;
        return false;
    }

    // tabulation
    public boolean tabulation(String s, String p) {
        int n = s.length(), m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        for (boolean[] dpRow : dp) {
            Arrays.fill(dpRow, false);
        }

        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        return solve(n - 1, m - 1, s, p, dp);
    }


    public static void main(String[] args) {
        RegularExpressionMatching o = new RegularExpressionMatching();
        String s = "aa", p = "a*";
        System.out.println(o.tabulation(s, p));
    }
}
