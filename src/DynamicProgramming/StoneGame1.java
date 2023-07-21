package DynamicProgramming;
import java.util.*;

public class StoneGame1 {

    private int solve(int i, int j, boolean turn, int[] piles, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (turn) {
            int result1 = solve(i + 1, j, false, piles, dp) + piles[i];
            int result2 = solve(i, j - 1, false, piles, dp) + piles[j];
            return dp[i][j] = Math.max(result1, result2);
        }
        int result1 = solve(i + 1, j, true, piles, dp) - piles[i];
        int result2 = solve(i, j - 1, true, piles, dp) - piles[j];
        return dp[i][j] = Math.max(result1, result2);
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n + 1][n + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        int ans = solve(0, n - 1, true, piles, dp);
        return ans >= 0 ? true : false;
    }

    public static void main(String[] args) {

    }
}
