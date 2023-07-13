package DynamicProgramming;
import java.util.*;

public class MinimumDifficultyOfJobSchedule {

    private int solve(int index, int d, int[] nums, int[][] dp) {
        if (index == nums.length && d == 0) {
            return 0;
        }
        if (d <= 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[index][d] != -1) {
            return dp[index][d];
        }

        int maxi = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = index; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);

            int value = solve(i + 1, d - 1, nums, dp);
            if (value != Integer.MAX_VALUE) {
                min = Math.min(min, value + maxi);
            }
        }
        return dp[index][d] = min;
    }

    public int minimumDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        int[][] dp = new int[n + 1][d + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        int ans = solve(0, d, jobDifficulty, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        MinimumDifficultyOfJobSchedule o = new MinimumDifficultyOfJobSchedule();
        int[] nums = {1, 1, 1};
        int d = 3;
//        System.out.println(o.tabulation(nums, d));
    }
}
