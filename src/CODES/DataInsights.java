package CODES;

import java.util.Arrays;

public class DataInsights {


    private int helper(int index, int prev, int k, int[][] nums) {
        if (k == 0 || index == nums.length) {
            return 0;
        }

        int pick = 0;
        if (nums[index][0] > prev) {
            pick = nums[index][2] + helper(index + 1, nums[index][1], k - 1, nums);
        }

        int notPick = helper(index + 1, prev, k, nums);
        return Math.max(pick, notPick);
    }

    public int solve(int[][] nums, int k) {
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        return helper(0, -1, k, nums);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;
        DataInsights o = new DataInsights();
        System.out.println(o.solve(nums, k));
    }
}
