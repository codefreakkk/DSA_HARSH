package DynamicProgramming;

import java.util.Arrays;

public class DivisorGame {

    private boolean solve(int n, int[] dp) {
        if (n <= 1) return false;

        if (dp[n] != -1) {
            if (dp[n] == 0) return false;
            return true;
        }

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                if (!solve(n - i, dp)) {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        dp[n] = 0;
        return false;
    }

    public boolean divisorGame(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    public static void main(String[] args) {

    }
}
