package DSA_REVISION.Arrays;

import java.util.*;

public class MaximumScoreFromSubarrayMinimums {

    public int pairWithMaxSum(List<Integer> nums) {
        int n = nums.size(), ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, nums.get(i) + nums.get(i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
