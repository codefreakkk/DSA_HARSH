package COMPANY_PROBLEMS;
import java.util.*;

public class Avalara_1 {

    public static int findDistinctPairs(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(Math.abs(target - nums[i]))) {
                ans++;
            }
            map.put(nums[i], nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12};
        System.out.println(findDistinctPairs(nums, 2));
    }
}
