package DynamicProgramming;
import java.util.*;

public class DeleteAndEarn {

    private int solve(int index, int[] nums, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) return dp[index];

        int notPick = solve(index + 1, nums, dp);
        int pick = solve(index + 2, nums, dp) + nums[index] * index;

        return dp[index] = Math.max(notPick, pick);
    }

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        int max = 0;
        for (int it : nums) {
            max = Math.max(max, it);
        }

        int[] list = new int[max + 1];
        for (int it : nums) {
            list[it]++;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return solve(1, list, dp);
    }

    public static void main(String[] args) {
        DeleteAndEarn o = new DeleteAndEarn();
        int[] nums = {1,8,5,9,6,9,4,1,7,3,3,6,3,3,8,2,6,3,2,2,1,2,9,8,7,1,1,10,6,7,3,9,6,10,5,4,10,1,6,7,4,7,4,1,9,5,1,5,7,5};
        System.out.println(o.deleteAndEarn(nums));
    }
}
