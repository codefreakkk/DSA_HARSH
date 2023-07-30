package RANDOM_PROBLEM;

import java.util.Arrays;

public class BNY_3_PICT {

    private boolean check(int mid, int server, int money, int sell, int upgrade) {
        int remaining_server = server - mid;
        if (remaining_server <= 0) {
            return false;
        }

        long totalCost = money + (sell * mid);
        long sold = totalCost / upgrade;

        return remaining_server <= sold;
    }

    public int[] getMaxUpgradedServer(int[] num_server, int[] money, int[] sell, int[] upgrade) {
        int n = num_server.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 1, high = num_server[i];

            int value = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (check(mid, num_server[i], money[i], sell[i], upgrade[i])) {
                    high = mid - 1;
                    value = num_server[i] - mid;
                }
                else {
                    low = mid + 1;
                }
            }
            ans[i] = value;
        }
        return ans;
    }

    public static void main(String[] args) {
        BNY_3_PICT o = new BNY_3_PICT();
        int[] num = {12};
        int[] money = {12};
        int[] sell = {2};
        int[] upgrade = {2};
        int[] ans = o.getMaxUpgradedServer(num, money, sell, upgrade);
        System.out.println(Arrays.toString(ans));
    }
}
