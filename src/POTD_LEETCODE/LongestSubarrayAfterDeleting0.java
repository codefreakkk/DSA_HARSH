package POTD_LEETCODE;

public class LongestSubarrayAfterDeleting0 {

    public static int longestSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0, flag = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int left = i - 1, right = i + 1;
                while (left >= 0 && nums[left] == 1) {
                    left--;
                }
                while (right < n && nums[right] == 1) {
                    right++;
                }
                int sum = 0;
                if (left == -1) {
                    sum = i + (right - i) - 1;
                }
                else {
                    sum = (i - left) + (right - i) - 2;
                }
                ans = Math.max(ans, sum);
                flag = 1;
            }
        }
        return flag == 0 ? n - 1 : ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(longestSubarray(nums));
    }
}
