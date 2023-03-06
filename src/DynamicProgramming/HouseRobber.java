package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    // memoization
    private int solve(int index, int[] nums, int[] dp) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];
        int pick = nums[index] + solve(index - 2, nums, dp);
        int notPick = solve(index - 1, nums, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    // memoization
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n - 1, nums, dp);
    }

    // tabulation
    public int robTabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    public int robTabulationOptimized(int[] nums) {
        int n = nums.length;
        int prev = nums[0], prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = prev;
            int current = Math.max(pick, notPick);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        HouseRobber o = new HouseRobber();
        int[] nums = {5,5,10,100,10,5};
//        System.out.println(o.rob(nums));
        System.out.println(o.robTabulation(nums));
    }
}
