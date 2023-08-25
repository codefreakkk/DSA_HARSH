package DynamicProgramming;
import java.util.*;

public class InterleavingString {

    // memoization
    private boolean solve(int i, int j, int index, String s1, String s2, String s3, int[][][] dp) {
        if (index == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        if (dp[i][j][index] != -1) {
            return dp[i][j][index] == 1 ? true : false;
        }

        boolean left = false, right = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(index)) {
            left = solve(i + 1, j, index + 1, s1, s2, s3, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(index)) {
            right = solve(i, j + 1, index + 1, s1, s2, s3, dp);
        }
        dp[i][j][index] = (left || right) == true ? 1 : 0;
        return left || right;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();

        int[][][] dp = new int[len1 + 1][len2 + 1][len3 + 1];
        for (int[][] dpMat : dp) {
            for (int[] dpRow : dpMat) {
                Arrays.fill(dpRow, -1);
            }
        }
        return solve(0, 0, 0, s1, s2, s3, dp);
    }

    // tabulation not working
    public boolean tabulation(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();

        int[][][] dp = new int[len1 + 1][len2 + 1][len3 + 1];
        dp[len1][len2][len3] = 1;

        for (int index = len3 - 1; index >= 0; index--) {
            for (int i = len1 - 1; i >= 0; i--) {
                for (int j = len2 - 1; j >= 0; j--) {
                    boolean left = false, right = false;

                    if (s1.charAt(i) == s3.charAt(index)) {
                        left = dp[i + 1][j][index + 1] == 1 ? true : false;
                    }
                    if (s2.charAt(j) == s3.charAt(index)) {
                        right = dp[i][j + 1][index + 1] == 1 ? true : false;
                    }
                    dp[i][j][index] = (left || right) ? 1 : 0;
                }
            }
        }
        for (int[][] d : dp) {
            for (int[] dr : d) System.out.println(Arrays.toString(dr));
        }
        return dp[0][0][0] == 1 ? true : false;
    }

    public static void main(String[] args) {
        InterleavingString o = new InterleavingString();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(o.tabulation(s1, s2, s3));
    }
}
