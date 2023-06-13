package DynamicProgramming;

import java.util.ArrayList;

public class  PrintLongestIncreasingSubsequence {

    public ArrayList<Integer> lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE, lastIndex = 0;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;

        int[] hash = new int[n];
        for (int i = 0; i < n; i++) hash[i] = i;

        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] > nums[prev] && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    hash[index] = prev;
                }
            }
            if (dp[index] > maxi) {
                maxi = dp[index];
                lastIndex = index;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
