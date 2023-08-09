package POTD_LEETCODE;
import java.util.*;

public class MinimizeTheMaximumDifferenceOfPairs {

    private int isFiseable(int[] nums, int mid, int p) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; i++) {
            if (nums[i] - nums[i - 1] <= mid) {
                count++;
                i++;
            }
        }
        return count;
    }

    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0, high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isFiseable(nums, mid, p) >= p) {
                high = mid;
            }
            else low = mid + 1;
        }
        return low;
    }



    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3, 2, 1, 2};
        int p = 3;
//        System.out.println(minimizeMax(nums, p));
    }
}
