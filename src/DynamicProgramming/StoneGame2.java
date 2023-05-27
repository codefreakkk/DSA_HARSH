package DynamicProgramming;

import java.util.Arrays;

public class StoneGame2 {

    private static int solve(int[] nums, int m, int startIndex, int turn, int[][][] dp) {
        if (startIndex >= nums.length) return 0;
        if (dp[m][startIndex][turn] != -1) {
            return dp[m][startIndex][turn];
        }

        int ans = (turn == 0) ? 0 : Integer.MAX_VALUE;
        int takenCount = 0;

        for (int x = 1; x <= 2 * m; x++) {
            int pileIndex = startIndex + x - 1;
            if (pileIndex >= nums.length) break;
            takenCount += nums[pileIndex];

            if (turn == 0) {
                int count = solve(nums, Math.max(x, m), pileIndex + 1, 1, dp);
                int total = count + takenCount;
                ans = Math.max(ans, total);
            }
            else {
                int count = solve(nums, Math.max(x, m), pileIndex + 1, 0, dp);
                ans = Math.min(count, ans);
            }
        }
        return dp[m][startIndex][turn] = ans;
    }

    public static int stoneGame2(int[] nums) {
        int n = nums.length;

        int[][][] dp = new int[n + 1][n + 1][2];
        for (int[][] piles : dp) {
            for (int[] pile : piles) Arrays.fill(pile, -1);
        }

        return solve(nums, 1, 0, 0, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 100};
        System.out.println(stoneGame2(nums));
    }
}
