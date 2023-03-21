package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    private int solve(int index1, int index2, String s1, String s2, int[][] dp) {
        if (index1 < 0 || index2 < 0) return 0;
        if (dp[index1][index2] != -1) return dp[index1][index2];

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + solve(index1 - 1, index2 - 1, s1, s2, dp);
        }
        int left = solve(index1 - 1, index2, s1, s2, dp);
        int right = solve(index1, index2 - 1, s1, s2, dp);
        return dp[index1][index2] = Math.max(left, right);
    }

    public int longestPalindromicSubsequence(String s) {
        int n = s.length();
        String t = "";

        for (int i = n - 1; i >= 0; i--)
            t += s.charAt(i);

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, n - 1, s, t, dp);
    }

    public static void main(String[] args) {

    }
}
