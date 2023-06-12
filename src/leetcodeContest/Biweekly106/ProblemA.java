package leetcodeContest.Biweekly106;
import java.util.*;

public class ProblemA {

    private static void helper(int num, int[] nums) {
        while (num > 0) {
            int rem = num % 10;
            nums[rem] += 1;
            num /= 10;
        }
    }

    public static boolean isFascinating(int n) {
        int[] nums = new int[10];
        Arrays.fill(nums, 0);

        helper(n, nums);
        helper(n * 2, nums);
        helper(n * 3, nums);

        if (nums[0] == 1) return false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 || nums[i] > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 783;
        System.out.println(isFascinating(num));
    }
}
