package DynamicProgramming;
import java.util.*;

public class FrogJumpWithKDistance {

    // memoization
    private int solve(int index, int k, int[] nums, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = solve(index - i, k, nums, dp) + Math.abs(nums[index] - nums[index - i]);
                min = Math.min(jump, min);
            }
        }
        return dp[index] = min;
    }

    // memoization
    public int frogJumpMemoization(int[] nums, int N, int k) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return solve(N - 1, k, nums, dp);
    }

    // tabulation
    public int frogJumpTabulation(int[] nums, int N, int k) {
        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(nums[i - j] - nums[i]);
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        FrogJumpWithKDistance o = new FrogJumpWithKDistance();
        int[] nums = {10, 30, 40, 50, 20};
//        System.out.println(o.frogJumpMemoization(nums, nums.length, 3));
        System.out.println(o.frogJumpTabulation(nums, nums.length, 3));
    }
}
