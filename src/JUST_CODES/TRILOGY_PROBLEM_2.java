package JUST_CODES;
import java.util.*;

public class TRILOGY_PROBLEM_2 {

    public static int findWays(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;

        for (int i = n - 1; i >= 0; i--) {
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(findWays(nums));
    }
}
