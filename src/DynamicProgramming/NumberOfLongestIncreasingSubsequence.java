package DynamicProgramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    // tabulation
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    cnt[i] = cnt[prev];
                }
                else if (nums[i] > nums[prev] && 1 + dp[prev] == dp[i]) {
                    cnt[i] += cnt[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) ans += cnt[i];
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
