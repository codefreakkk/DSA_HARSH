package DynamicProgramming;
import java.util.*;

public class WildCardMatching {

    // memoization
    private boolean solve(int i, int j, String s, String t, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i >= 0 && j < 0) return false;
        if (i < 0 && j >= 0) {
            for (int index = 0; index <= j; index++) {
                if (t.charAt(index) != '*') return false;
            }
            return true;
        }
        if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

        if (s.charAt(i) == t.charAt(j) || t.charAt(j) == '?') {
            boolean value = solve(i - 1, j - 1, s, t, dp);
            dp[i][j] = value == true ? 1 : 0;
            return value;
        }
        if (t.charAt(j) == '*') {
            boolean left = solve(i - 1, j, s, t, dp);
            boolean right = solve(i, j - 1, s, t, dp);
            boolean ans = left || right;
            dp[i][j] = ans == true ? 1 : 0;
            return ans;
        }
        dp[i][j] = 0;
        return false;
    }

    // memoization
    public boolean isMatch(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, m - 1, s, t, dp);
    }

    // tabulation
    public boolean isMatchTabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        // base cases
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 1; j <= m; j++) {
            int flag = 1;
            for (int index = 1; index <= j; index++) {
                if (t.charAt(index - 1) != '*') {
                    flag = 0;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1) || t.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    if (t.charAt(j - 1) == '*') {
                        int left = dp[i - 1][j];
                        int right = dp[i][j - 1];
                        if (left == 1) dp[i][j] = left;
                        else dp[i][j] = right;
                    }
                    else dp[i][j] = 0;
                }
            }
        }
        return dp[n][m] == 1 ? true : false;
    }

    public static void main(String[] args) {
        WildCardMatching o = new WildCardMatching();
        String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
        String t = "*aabb***aa**a******aa*";
        System.out.println(o.isMatch(s, t));
    }
}
