package DynamicProgramming;
import java.util.*;
public class FrogJumpEASY {

    // memoization
    private int solve(int index, int[] nums, int[] dp) {
        if (index == 0) return 0;

        if (dp[index] != -1) return dp[index];
        int left = solve(index - 1, nums, dp) + Math.abs(nums[index] - nums[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
             right = solve(index - 2, nums, dp) + Math.abs(nums[index] - nums[index - 2]);
        }
        return dp[index] = Math.min(left, right);
    }

    // memoization
    public int frogJumpMemoization(int[] nums, int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return solve(N - 1, nums, dp);
    }



    // tabulation
    public int frogJumpTabulation(int[] nums, int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            int left = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(nums[i] - nums[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        FrogJumpEASY o = new FrogJumpEASY();
        int[] nums = {10, 20, 30, 10};
        System.out.println(o.frogJumpTabulation(nums, nums.length));
    }
}
