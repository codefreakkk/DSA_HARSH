package POTD_LEETCODE;

import java.util.Arrays;

public class KRadiusSubArrayAverages {

    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;

        int n = nums.length;
        long[] prefix = new long[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] ans = new int[n];
        long totalObjects = 2 * k + 1;
        for (int i = 0; i < n; i++) {
            if (i - k >= 0 && i + k < n) {
                long sum = 0;
                if (i - k == 0) {
                    sum = prefix[i + k];
                }
                else {
                    sum = prefix[i + k] - prefix[i - k - 1];
                }
                ans[i] = (int) (sum / totalObjects);
            }
            else ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }
}
