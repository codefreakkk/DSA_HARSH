package DynamicProgramming;
import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static String lcs(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) dp[0][j] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    int maxi = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = maxi;
                }
            }
        }
        int length = dp[n][m], index = length - 1;
        char[] ch = new char[length];
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ch[index--] = text1.charAt(i - 1);
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[j - 1][i]) {
                i--;
            }
            else j--;
        }
        String ans = "";
        for (i = 0; i < ch.length; i++)
            ans += ch[i];

        return ans;
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "bdgek";
        System.out.println(lcs(text1, text2));
    }
}
