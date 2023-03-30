package DynamicProgramming;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] nums) {
        int n = nums.length;
        int ans = 0, mini = nums[0];

        for (int i = 1; i < n; i++) {
            int profit = nums[i] - mini;
            ans = Math.max(ans, profit);
            mini = Math.min(nums[i], mini);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
