package POTD_LEETCODE;

public class LongestSubarrayAfterDeleting0 {

    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int left = i - 1, right = i + 1;
                int leftCount = 0, rightCount = 0;
                while (left >= 0 && nums[left] == 1) {
                    left--;
                }
                while (right < n && nums[right] == 1) {
                    right++;
                }
                int sum = (i - left) + (right - i) - 2;
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
