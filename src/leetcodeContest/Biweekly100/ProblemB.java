package leetcodeContest.Biweekly100;

import java.util.Arrays;

public class ProblemB {
    public static int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 1, ans = 0;

        while (right <= n - 1) {
            while (nums[right] <= nums[left]) {
                right++;
                if (right >= n) break;
            }
            if (right < n && nums[right] > nums[left]) ans++;
            left++;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(maximizeGreatness(nums));
    }
}
