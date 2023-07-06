package DynamicProgramming;
import java.util.*;

public class DecodeWays {

    private boolean check(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num <= 26;
    }

    // memoization code
    private int solve(int index, String s, int[] dp) {
        if (index >= s.length()) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = 0;
        for (int i = index; i < s.length(); i++) {
            if (check(s.substring(index, i + 1))) {
                ans += solve(i + 1, s, dp);
            }
            else break;
        }
        return dp[index] = ans;
    }

    public int numDecoding(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return tabulation(s);
    }

    // tabulation code
    public int tabulation(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int index = n - 1; index >= 0; index--) {
            int ans = 0;
            for (int i = index; i < n; i++) {
                if (check(s.substring(index, i + 1))) {
                    ans += dp[i + 1];
                }
                else break;
            }
            dp[index] = ans;
        }
        return dp[0];
    }


    public static void main(String[] args) {
        DecodeWays o = new DecodeWays();
        String num = "06";
        System.out.println(o.numDecoding(num));
    }
}
