package POTD_LEETCODE;
import java.util.*;

public class FindTheWinnerOfArrayGame {

    public static int getWinner(int[] nums, int k) {
        int n = nums.length;

        // base case
        if (k >= n) {
            int max = -1;
            for (int it : nums) {
                max = Math.max(max, it);
            }
            return max;
        }

        int current = nums[0], count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > current) {
                count = 0;
                current = nums[i];
            }
            if (++count == k) {
                break;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = {1, 25, 35, 42, 68, 70};
        int k = 2;
        System.out.println(getWinner(nums, k));
    }
}
