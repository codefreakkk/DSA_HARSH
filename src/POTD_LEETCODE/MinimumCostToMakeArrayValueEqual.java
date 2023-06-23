package POTD_LEETCODE;

public class MinimumCostToMakeArrayValueEqual {

    private long helper(int[] nums, int[] cost, long mid) {
        long val = 0l;
        for (int i = 0; i < nums.length; i++) {
            val += Math.abs(nums[i] - mid) * cost[i] * 1l;
        }
        return val;
    }

    public long minCost(int[] nums, int[] cost) {
        int low = nums[0];
        int high = nums[0];
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        long ans = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            long cost1 = helper(nums, cost, mid);
            long cost2 = helper(nums, cost, mid + 1);

            if (cost1 > cost2) {
                ans = cost2;
                low = mid + 1;
            }
            else {
                ans = cost1;
                high = mid;
            }
        }
        return ans;
    }


    public static void main(String[] args) {}
}
