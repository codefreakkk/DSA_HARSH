package Greedy;

import java.util.*;

public class ChocolateDistributionProblem {
    public long findMinDifference(ArrayList<Integer> nums, int n, int m) {
        Collections.sort(nums);
        int i = 0, j = m - 1;

        int min = Integer.MAX_VALUE;
        while (j < n) {
            int num = nums.get(j) - nums.get(i);
            min = Math.min(min, num);
            i++;
            j++;
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
