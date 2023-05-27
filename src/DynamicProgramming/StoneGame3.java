package DynamicProgramming;

import java.util.Arrays;

public class StoneGame3 {

    private int solve(int[] nums, int index, int[] dp) {
        if (index >= nums.length) return 0;
        if (dp[index] > Integer.MIN_VALUE) return dp[index];

        int sum = 0;
        for (int i = index; i < index + 3 && i < nums.length; i++) {
            sum += nums[i];
            dp[index] = Math.max(dp[index], sum - solve(nums, i + 1, dp));
        }
        return dp[index];
    }

    public String stoneGameIII(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int play = solve(nums, 0, dp);

        if (play == 0) return "Tie";
        else if (play > 0) return "Alice";
        return "Bob";
    }

    public static void main(String[] args) {

    }
}
