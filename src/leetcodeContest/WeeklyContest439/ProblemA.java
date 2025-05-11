package leetcodeContest.WeeklyContest439;

import java.util.*;

public class ProblemA {

    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            int windowSize = j - i + 1;


            if (windowSize < k) {
                j++;
            } else if (windowSize == k) {
                for (int index = i; index <= j; index++) {
                    if (index > i && nums[index] != nums[index - 1]) {
                        map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
                    }
                }
                i++;
                j++;
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (mp.getValue() == 1) {
                ans = Math.max(mp.getKey(), ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,9,7,2,1,7};
        ProblemA o = new ProblemA();
        System.out.println(o.largestInteger(nums, 4));
    }

}
