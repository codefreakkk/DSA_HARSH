package DynamicProgramming;
import java.util.*;

public class LongestCommonSubsequence {

    // memoization
    private int solve(int index1, int index2, String text1, String text2, int[][] dp) {
        if (index1 < 0 || index2 < 0) return 0;
        if (dp[index1][index2] != -1) return dp[index1][index2];

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + solve(index1 - 1, index2 - 1, text1, text2, dp);
        }
        int maxi = Math.max(solve(index1 - 1, index2, text1, text2, dp), solve(index1, index2 - 1, text1, text2, dp));
        return dp[index1][index2] = maxi;
    }

    // memoization
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, m - 1, text1, text2, dp);
    }

    // tabulation
    public static int longestCommonSubsequenceTabulation(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = max;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "babcd", s2 = "dcbab";
        System.out.println(longestCommonSubsequenceTabulation(s1, s2));
    }
}
