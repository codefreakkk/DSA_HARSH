package DynamicProgramming;
import java.util.*;
public class BestTimeToBuyAndSellStock4 {

    // memoization
    private int solve(int index, int trans, int k, int[] nums, int[][] dp) {
        if (index == nums.length || trans == 2*k) return 0;
        if (dp[index][trans] != -1) return dp[index][trans];

        if (trans % 2 == 0) {
            int pick = -nums[index] + solve(index + 1, trans + 1, k, nums, dp);
            int notPick = solve(index + 1, trans, k, nums, dp);
            dp[index][trans] = Math.max(pick, notPick);
        }
        else {
            int pick = nums[index] + solve(index + 1, trans + 1, k, nums, dp);
            int notPick = solve(index + 1, trans, k, nums, dp);
            dp[index][trans] = Math.max(pick , notPick);
        }
        return dp[index][trans];
    }

    // memoization
    public int maxProfit(int k, int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, k, nums, dp);
    }

    // tabulation
    public int maxProfitTabulation(int k, int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2*k + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int trans = 2*k - 1; trans >= 0; trans--) {
                if (trans % 2 == 0) {
                    int pick = -nums[index] + dp[index + 1][trans + 1];
                    int notPick = dp[index + 1][trans];
                    dp[index][trans] = Math.max(pick, notPick);
                }
                else {
                    int pick = nums[index] + dp[index + 1][trans + 1];
                    int notPick = dp[index + 1][trans];
                    dp[index][trans] = Math.max(pick, notPick);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
