package DynamicProgramming;

import java.util.Arrays;

public class MinimumNumbersOfremovalToMakeMountainArray {

    public int minimumMountainRemovals(int[] nums) {
        int n =  nums.length;

        // memoization dp1
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        // memoization dp2
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        // traverse from left
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && 1 + dp1[prev] > dp1[i]) {
                    dp1[i] = 1 + dp1[prev];
                }
            }
        }

        // traverse from right
        for (int i = n - 2; i >= 0; i--) {
            for (int prev = n - 1; prev > i; prev--) {
                if (nums[i] > nums[prev] && 1 + dp2[prev] > dp2[i]) {
                    dp2[i] = 1 + dp2[prev];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                ans = Math.max(ans, (dp1[i] + dp2[i]) - 1);
            }
        }
        return n - ans;
    }

    public static void main(String[] args) {

    }
}
