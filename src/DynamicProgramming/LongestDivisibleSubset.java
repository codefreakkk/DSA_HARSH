package DynamicProgramming;

import java.util.*;

public class LongestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for (int i = 0; i < n; i++) hash[i] = i;

        int maxi = Integer.MIN_VALUE, maxIndex = 0;
        for (int index = 1; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] % nums[prev] == 0 && 1 + dp[prev] > dp[index]) {
                    hash[index] = prev;
                    dp[index] = 1 + dp[prev];
                }
            }
            if (dp[index] > maxi) {
                maxi = dp[index];
                maxIndex = index;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[maxIndex]);

        while (hash[maxIndex] != maxIndex) {
            maxIndex = hash[maxIndex];
            ans.add(nums[maxIndex]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }
}
