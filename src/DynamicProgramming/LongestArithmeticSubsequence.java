package DynamicProgramming;
import java.util.*;

public class LongestArithmeticSubsequence {
    private int solve(int index, int diff, int[] nums, HashMap<Integer, Integer>[] dp) {
        if (index < 0) return 0;

        if (dp[index].containsKey(diff)) {
            return dp[index].get(diff);
        }

        int count = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] - nums[i] == diff) {
                count = Math.max(count, 1 + solve(i, diff, nums, dp));
            }
        }
        dp[index].put(diff, count);
        return count;
    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> dp[] = new HashMap[n + 1];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int val = solve(i, nums[j] - nums[i], nums, dp);
                ans = Math.max(ans, 2 + val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
