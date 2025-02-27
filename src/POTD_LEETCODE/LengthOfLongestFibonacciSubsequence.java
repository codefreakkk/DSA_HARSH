package POTD_LEETCODE;

import java.util.*;

public class LengthOfLongestFibonacciSubsequence {

    private int solve(int first, int second, Map<Integer, Integer> map) {
        int nextElement = first + second;
        if (!map.containsKey(nextElement)) {
            return 2;
        }

        return solve(second, nextElement, map) + 1;
    }

    public int lenLongestFibSubseq(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                ans = Math.max(ans, solve(nums[i], nums[j], map));
            }
        }
        return ans > 2 ? ans : 0;
    }

    public static void main(String[] args) {

    }

}
