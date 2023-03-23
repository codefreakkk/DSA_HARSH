package DynamicProgramming;

public class ShortestCommonSuperSequenceLeetCode {

    private void lcs(String str1, String str2, int n, int m, int[][] dp) {
        for (int i = 0; i <= m; i++) dp[0][i] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = max;
                }
            }
        }
    }

    public String shortestCommonSuperSequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        lcs(str1, str2, n, m, dp);

        int i = n, j = m;
        String temp = "";
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                temp += str1.charAt(i - 1);
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                temp += str1.charAt(i - 1);
                i--;
            }
            else {
                temp += str2.charAt(j - 1);
                j--;
            }
        }
        // catch remaining indexes
        while (i > 0) {
            temp += str1.charAt(i - 1);
            i--;
        }
        while (j > 0) {
            temp += str2.charAt(j - 1);
            j--;
        }

        StringBuilder ans = new StringBuilder(temp);
        return ans.reverse().toString();
    }

    public static void main(String[] args) {

    }
}
