package RANDOM_PROBLEM;
import java.util.*;

public class Problem_1 {

    public static long getMaxOrSum(List<Integer> nums, int k) {
        int n = nums.size();
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long power = (long) Math.pow(2, k);
            long num = nums.get(i) * power;

            long sum = num;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum ^= nums.get(j);
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(12, 9);
        System.out.println(getMaxOrSum(l, 1));
    }
}
