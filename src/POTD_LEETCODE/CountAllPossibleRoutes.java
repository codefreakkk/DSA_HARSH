package POTD_LEETCODE;

import java.util.Arrays;

public class CountAllPossibleRoutes {

    private int MOD = (int) 1e9+7;

    private int solve(int index, int finish, int remainingFuel, int[] nums, int[][] dp) {
        if (remainingFuel < 0) {
            return 0;
        }

        if (dp[index][remainingFuel] != -1) {
            return dp[index][remainingFuel];
        }

        int ans = index == finish ? 1 : 0;

        for (int i = 0; i < nums.length; i++) {
            int fuelCost = Math.abs(nums[index] - nums[i]);

            if (i != index && remainingFuel >= fuelCost) {
                ans = (ans + solve(i, finish, remainingFuel - fuelCost, nums, dp)) % MOD;
            }
        }
        return dp[index][remainingFuel] = ans;
    }

    public int countRoutes(int[] nums, int start, int finish, int fuel) {
        int n = nums.length;

        int[][] dp = new int[n + 1][fuel + 1];
        for (int[] dpRow : dp) Arrays.fill(dpRow, -1);

        return solve(start, finish, fuel, nums, dp);
    }

    public static void main(String[] args) {
        int[] nums = {4,3,1};
        int start = 1, finish = 0, fuel = 6;
    }
}
