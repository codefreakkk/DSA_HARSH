package JUST_CODES;
import java.util.*;

public class ReducingDishes {

    public static int maxSatisfaction(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = 0, timer = 1;

            for (int j = i; j < n; j++) {
                temp += nums[j] * timer++;
            }
            ans = Math.max(temp, ans);
        }
        return ans < 0 ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-4,-5};
        System.out.println(maxSatisfaction(nums));
    }
}
