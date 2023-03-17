package DynamicProgramming;

public class CountPartitionsWithGivenDifference {
    private int solve(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= k) dp[0][nums[0]] = 1;
        if (nums[0] == 0) dp[0][0] = 2;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                int notPick = dp[i - 1][target];

                int pick = 0;
                if (nums[i] <= target)
                    pick = dp[i - 1][target - nums[i]];

                dp[i][target] = (notPick + pick);
            }
        }
        return dp[n - 1][k];
    }

    public int countPartition(int[] nums, int d) {
        int sum = 0;
        for (int num : nums) sum += num;

        // edge case
        if (sum - d < 0 || sum % 2 != 1) return 0;
        return solve(nums, (sum - d) / 2);
    }

    public static void main(String[] args) {

    }
}
