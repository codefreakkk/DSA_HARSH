package COMPANY_PROBLEMS;

import java.util.*;

public class Leetcode_2762 {

    public static long continousSubarray(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int i = 0, j = 0;
        long ans = 0;

        while (i < n) {
            while (j < n && (map.size() == 0 || Math.max(nums[j], map.lastKey()) - Math.min(nums[j], map.firstKey()) <= 2)) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                j++;
            }

            // update ans
            for (Map.Entry<Integer, Integer> it : map.entrySet()) {
                ans += it.getValue();
            }

            // remove key from map
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) - 1);

                // remove key from map if it becomes 0
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
            }
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,2, 3};
        System.out.println(continousSubarray(nums));
    }
}
