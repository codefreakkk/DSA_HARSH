package DynamicProgramming;

import java.util.*;

public class BurstBalloons {


    // memoization
    private int solve(int i, int j, List<Integer> nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = nums.get(i - 1) * nums.get(index) * nums.get(j + 1);
            cost += solve(i, index - 1, nums, dp);
            cost += solve(index + 1, j, nums, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    // memoization
    public int maxCoins(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < n; i++) list.add(nums[i]);
        list.add(1);

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, n, list, dp);
    }

    // tabulation
    public int maxCoinsTabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < n; i++) list.add(nums[i]);
        list.add(1);

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;

                int max = Integer.MIN_VALUE;
                for (int index = i; index <= j; index++) {
                    int cost = list.get(i - 1) * list.get(index) * list.get(j + 1);
                    cost += dp[i][index - 1];
                    cost += dp[index + 1][j];
                    max = Math.max(max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {

    }
}
