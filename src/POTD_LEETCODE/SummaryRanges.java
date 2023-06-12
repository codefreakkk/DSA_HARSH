package POTD_LEETCODE;

import java.util.*;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (i != start) {
                String output = String.valueOf(nums[start]) + "->" + String.valueOf(nums[i]);
                ans.add(output);
            }
            else {
                ans.add(String.valueOf(nums[i]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
