package POTD_LEETCODE;

import java.util.*;

public class LongestArithmeticSubsequenceOfGivenDifference {

    private int solve(int index, int prev, int[] nums, int difference, int[][] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        int pick = 0, notPick = 0;
        if (prev == -1 || nums[index] - nums[prev] == difference) {
            pick = 1 + solve(index + 1, index, nums, difference, dp);
        }
        notPick = solve(index + 1, prev, nums, difference, dp);
        return dp[index][prev + 1] = Math.max(pick, notPick);
    }

    public int tabulation(int[] nums, int difference) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num - difference)) {
                map.put(num, map.getOrDefault(num - difference, 0) + 1);
            }
            else {
                map.put(num, 1);
            }

            ans = Math.max(ans, map.get(num));
        }
        return ans;
    }

    public int longestSubsequence(int[] nums, int difference) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        return solve(0, -1, nums, difference, dp);
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference o = new LongestArithmeticSubsequenceOfGivenDifference();
        int[] nums = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(o.tabulation(nums, difference));
    }
}
