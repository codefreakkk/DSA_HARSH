package DynamicProgramming;

public class MinimumInsertionDeletionToConvertStringAtoB {

    private int lcs(String s1, String s2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
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

    public int minOperations(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int lcsLength = lcs(str1, str2, n, m);
        return (n + m) - (2 * lcsLength);
    }

    public static void main(String[] args) {

    }
}
