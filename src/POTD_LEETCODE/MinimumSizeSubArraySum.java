package POTD_LEETCODE;

public class MinimumSizeSubArraySum {

    public static int minSubarrayLen(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = 0, ans = Integer.MAX_VALUE;

        int sum = 0;
        while (i < n) {
            if (sum < target && j < n) {
                sum += nums[j];
                j++;
            }
            else {
                if (sum >= target) {
                    ans = Math.min(ans, j - i);
                }
                sum -= nums[i];
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        System.out.println(minSubarrayLen(nums, target));
    }
}
