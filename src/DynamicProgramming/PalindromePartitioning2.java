package DynamicProgramming;

import java.util.*;

public class PalindromePartitioning2 {


    // utility function
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // memoization
    private int solve(int index, String s, int[] dp) {
        if (index == s.length())
            return 0;

        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(index, i, s)) {
                int cost = 1 + solve(i + 1, s, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[index] = min;
    }

    // memoization
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, s, dp) - 1;
    }

    // tabulation
    public int minCutTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {

    }
}
