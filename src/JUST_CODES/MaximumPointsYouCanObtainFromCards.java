package JUST_CODES;

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {

    public static int maxScore(int[] nums, int k) {
            int n = nums.length;
            int i = 0, j = 0, ans = Integer.MIN_VALUE, sum = 0;

            int totalSum = Arrays.stream(nums).sum();

            while (j < n) {
                sum += nums[j];
                if (j < n - k - 1) j++;
                else {
                    ans = Math.max(ans, totalSum - sum);
                    sum -= nums[i++];
                    j++;
                }
            }
            return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(nums, k));
    }
}
