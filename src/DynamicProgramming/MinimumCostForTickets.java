package DynamicProgramming;
import java.util.*;

public class MinimumCostForTickets {

    private int upperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) return mid + 1;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private int solve(int index, int[] days, int[] costs, int[] target, int[] dp) {
        if (index >= days.length) {
            return 0;
        }
        if (dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int newIndex = upperBound(days, days[index] + target[i] - 1);
            int cost = costs[i] + solve(newIndex, days, costs, target, dp);
            min = Math.min(min, cost);
        }
        return dp[index] = min;
    }

    public int minCostTickets(int[] days, int[] costs) {
        int n = days.length;

        int[] target = {1, 7, 30};

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, days, costs, target, dp);
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};
        MinimumCostForTickets o = new MinimumCostForTickets();
        System.out.println(o.minCostTickets(nums, cost));
    }
}
