package POTD_LEETCODE;

public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];
            if (customers.charAt(i - 1) == 'N') {
                prefix[i] += 1;
            }
        }

        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if (customers.charAt(i) == 'Y') {
                suffix[i] += 1;
            }
        }

        int ans = 0, penalty = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int sum = suffix[i] + prefix[i];
            if (sum < penalty) {
                ans = i;
                penalty = sum;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
