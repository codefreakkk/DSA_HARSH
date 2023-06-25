package POTD_LEETCODE;

import java.util.Arrays;

public class TallestBillBoard {

    private int solve(int index, int diff, int[] rods, int[][] dp) {
        if (index == rods.length) {
            if (diff == 0) {
                return diff;
            }
            return Integer.MIN_VALUE;
        }

        if (dp[index][diff + 5001] != -1) return dp[index][diff + 5001];

        int notPick = solve(index + 1, diff, rods, dp);
        int pick1 = rods[index] + solve(index + 1, diff + rods[index], rods, dp);
        int pick2 = solve(index + 1, diff - rods[index], rods, dp);

        int ans = Math.max(notPick, Math.max(pick1, pick2));
        return dp[index][diff + 5001] = ans;
    }

    public int tallestBillboard(int[] rods) {
        int[][] dp = new int[21][10005];
        for (int[] dpRow : dp) Arrays.fill(dpRow, -1);

        return solve(0, 0, rods, dp);
    }
    
    public static void main(String[] args) {

    }
}
