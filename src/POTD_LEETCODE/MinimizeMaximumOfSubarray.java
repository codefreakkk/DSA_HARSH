package POTD_LEETCODE;
import java.util.*;

public class MinimizeMaximumOfSubarray {

    public static int minimizeArrayValue(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];
        long maxi = prefix[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            long result = (long) Math.ceil(prefix[i] / (double) (i + 1));
            maxi = Math.max(maxi, result);
        }
        return (int) maxi;
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 1, 6};
        System.out.println(minimizeArrayValue(nums));
    }
}
