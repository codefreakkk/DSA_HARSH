package DynamicProgramming;

import java.util.Arrays;

public class FibonacciNumber {

    // memoization
    private int f1(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];
        return dp[n] = f1(n - 1, dp) + f1(n - 2, dp);
    }

    // memoization
    public int fiboMemoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f1(n, dp);
    }

    // tabulation
    public int fiboTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    // tabulation optimized
    public int fiboTabulationOptimized(int n) {
        int prev2 = 0, prev = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
    public static void main(String[] args) {
        FibonacciNumber o = new FibonacciNumber();
        System.out.println(o.fiboTabulationOptimized(5));
    }
}
