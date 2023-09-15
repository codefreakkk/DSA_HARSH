package COMPANY_PROBLEMS;

import java.util.*;

public class Oracle_1 {

    public static int countPalindromes(List<String> arr) {
        int n = arr.size();
        int[][] dp = new int[n + 1][n + 1];

        // Initialize the dp table.
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (arr.get(i - 1).charAt(0) == arr.get(j - 1).charAt(0)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Find the maximum number of palindromic strings.
        int maxPalindromes = 0;
        for (int i = 0; i <= n; i++) {
            maxPalindromes = Math.max(maxPalindromes, dp[i][n]);
        }

        return maxPalindromes;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("pass", "sas", "asps", "df");
        int n = arr.size();

        int maxPalindromes = countPalindromes(arr);
        System.out.println("The maximum number of palindromic strings is: " + maxPalindromes);
    }
}
