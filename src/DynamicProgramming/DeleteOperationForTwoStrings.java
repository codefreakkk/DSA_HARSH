package DynamicProgramming;

public class DeleteOperationForTwoStrings {
    private int lcs(String word1, String word2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
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

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int length = lcs(word1, word2, n, m);

        return (n + m) - (2 * length);
    }

    public static void main(String[] args) {

    }
}
