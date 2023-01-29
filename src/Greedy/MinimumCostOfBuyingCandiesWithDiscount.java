package Greedy;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minCost(int[] cost) {
        int ans = 0, n = cost.length;
        Arrays.sort(cost);

        for (int i  = 0; i < n; i++) {
            if (i % 3 != n % 3) ans += cost[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
