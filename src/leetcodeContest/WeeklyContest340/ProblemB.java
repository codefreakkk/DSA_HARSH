package leetcodeContest.WeeklyContest340;

import java.util.*;

// not solved

public class ProblemB {
    public static long[] distance(int[] nums) {
        int n = nums.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        long[] ans = new long[n];

        // store frequency
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
            else map.get(nums[i]).add(i);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> indices = map.get(nums[i]);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,5,3};
        System.out.println(Arrays.toString(distance(nums)));
    }
}
