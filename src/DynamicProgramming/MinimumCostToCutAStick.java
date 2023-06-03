package DynamicProgramming;
import java.util.*;

public class  MinimumCostToCutAStick {

    // memoization
    private int solve(int i, int j, List<Integer> nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = nums.get(j + 1) - nums.get(i - 1);
            cost += solve(i, index - 1, nums, dp);
            cost += solve(index + 1, j, nums, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    // memoization
    public int minCost(int n, int[] cuts) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < cuts.length; i++) nums.add(cuts[i]);
        nums.add(0);
        nums.add(n);
        Collections.sort(nums);

        int[][] dp = new int[n +1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(1, cuts.length, nums, dp);
    }

    // tabulation
    public int minCostTabulation(int n, int[] cuts) {
        int c = cuts.length;
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(n);

        for (int i = 0; i < c; i++) nums.add(cuts[i]);
        Collections.sort(nums);

        int[][] dp = new int[n + 2][n + 2];

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;
                for (int index = i; index <= j; index++) {
                    int cost = nums.get(j + 1) - nums.get(i - 1);
                    cost += dp[i][index - 1];
                    cost += dp[index + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }

    public static void main(String[] args) {

    }
}
