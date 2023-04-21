package DynamicProgramming;
import java.util.*;

public class ProfitableSchemes {

    private int MOD = (int) 1e9+7;

    // memoization
    private int solve(int index, int people, int minProfit, int[] group, int[] profit, int[][][] dp) {
        if (people < 0) return 0;
        if (index == profit.length) {
            if (minProfit > 0) return 0;
            return 1;
        }
        if (minProfit < 0) minProfit = 0;
        if (dp[index][people][minProfit] != -1) return dp[index][people][minProfit];

        int notPick = solve(index + 1, people, minProfit, group, profit, dp);
        int pick = solve(index + 1, people - group[index], minProfit - profit[index], group, profit, dp);

        return dp[index][people][minProfit] = (notPick + pick) % MOD;
    }

    // memoization
    public int profit(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len][n][minProfit];

        for (int[][] rows : dp) {
            for (int[] row : rows) Arrays.fill(row, -1);
        }

        return solve(0, n, minProfit, group, profit, dp);
    }

    public static void main(String[] args) {

    }
}
