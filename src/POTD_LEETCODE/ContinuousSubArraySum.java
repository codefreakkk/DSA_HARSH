package POTD_LEETCODE;
import java.util.*;

public class ContinuousSubArraySum {

    public static boolean checkSubArraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i + 1);
            }
            else {
                if (map.get(sum % k) < i) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 5;
        System.out.println(checkSubArraySum(nums, k));
    }
}
