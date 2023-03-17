package DynamicProgramming;

public class MinimumSubsetSumDifference {
    public static int minSubsetSumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // tabulation
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (nums[0] <= sum) dp[0][sum] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean notPick = dp[i - 1][target];

                boolean pick = false;
                if (nums[i] <= target) {
                    int newIndex = target - nums[i];
                    pick = dp[i - 1][newIndex];
                }
                dp[i][target] = notPick || pick;
            }
        }

        // calculation
        int mini = (int) 1e9;
        for (int i = 0; i <= sum; i++) {
            if (dp[n - 1][i] == true) {
                int difference = Math.abs(i - (sum - i));
                mini = Math.min(mini, difference);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4};
        System.out.println(minSubsetSumDifference(nums));
    }
}
