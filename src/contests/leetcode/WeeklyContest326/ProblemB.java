package contests.leetcode.WeeklyContest326;

import java.util.*;

public class ProblemB {
    public static void getPrimeFactorOfNumber(Set<Integer> set, int num) {
        int divisor = 2;
        while (num > 1) {
            if (num % divisor == 0) {
                set.add(divisor);
                num /= divisor;
            }
            else
                divisor++;
        }
    }
    public static int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            getPrimeFactorOfNumber(set, i);

        return set.size();
    }
    public static void main(String[] args) {
        int[] nums = {2,4,8,16};
        System.out.println(distinctPrimeFactors(nums));
    }
}
