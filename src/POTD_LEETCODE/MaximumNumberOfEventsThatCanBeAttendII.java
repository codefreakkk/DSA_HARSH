package POTD_LEETCODE;
import java.util.*;

public class MaximumNumberOfEventsThatCanBeAttendII {

    private int findTargetIndex(int index, int target, int[][] events) {
        int n = events.length;
        int low = index, high = n - 1, ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > target) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }


    // memoization
    private int solve(int index, int k, int[][] events, int[][] dp) {
        if (k == 0 || index >= events.length || index == -1) {
            return 0;
        }

        if (dp[index][k] != -1) {
            return dp[index][k];
        }

        int target = findTargetIndex(index + 1, events[index][1], events);

        int attend = events[index][2] + solve(target, k - 1, events, dp);
        int notAttend = solve(index + 1, k, events, dp);

        return dp[index][k] = Math.max(attend, notAttend);
    }

    // tabulation
    public int tabulation(int[][] events, int K) {
        int n = events.length;
        int[][] dp = new int[n + 1][K + 1];

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for (int index = n - 1; index >= 0; index--) {
                int target = findTargetIndex(index + 1, events[index][1], events);

                for (int k = 1; k <= K; k++) {
                int attend = events[index][2] + dp[target][k - 1];
                int notAttend = dp[index + 1][k];

                dp[index][k] = Math.max(attend, notAttend);
            }
        }
        return dp[0][K];
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int[][] dp = new int[n + 1][k + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        return solve(0, k, events, dp);
    }

    public static void main(String[] args) {
        MaximumNumberOfEventsThatCanBeAttendII o = new MaximumNumberOfEventsThatCanBeAttendII();
        int[][] nums = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
//        int[][] nums = {{1, 2, 4}, {3,4,3}, {2, 3, 10}};
        int k = 2;
        System.out.println(o.tabulation(nums, k));
    }
}
