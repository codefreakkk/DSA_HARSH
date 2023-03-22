package DynamicProgramming;

public class MinimumInsertionsToMakeStringPalindrome {

    private int lcs(String s, String reverse) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int j = 0; j <= n; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reverse.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    int max = Math.max(dp[i - 1][j], dp[j][i - 1]);
                    dp[i][j] = max;
                }
            }
        }
        return dp[n][n];
    }

    public int minimumInsertions(String s) {
        int n = s.length();

        StringBuilder t = new StringBuilder(s);
        String reverse = t.reverse().toString();

        return n - lcs(s, reverse);
    }

    public static void main(String[] args) {

    }
}
