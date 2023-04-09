package DynamicProgramming;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    // memoization
    private int solve(int index, int[] nums, int k, int[] dp) {
        if (index == nums.length) return 0;
        if (dp[index] != -1) return dp[index];

        int ans = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int len = 0;
        for (int i = index; i < Math.min(nums.length, index + k); i++) {
            len++;
            max = Math.max(max, nums[i]);
            int sum = (len * max) + solve(i + 1, nums, k, dp);
            ans = Math.max(sum, ans);
        }
        return dp[index] = ans;
    }

    // memoization
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, nums, k, dp);
    }

    // tabulation
    public int partitionArrayTabulation(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
            int len = 0;

            for (int index = i; index < Math.min(n, i + k); index++) {
                len++;
                max = Math.max(max, nums[index]);
                int sum = (len * max) + dp[index + 1];
                ans = Math.max(ans, sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
