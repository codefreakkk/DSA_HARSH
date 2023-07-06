package RANDOM_PROBLEM;
import java.util.*;

public class Leetcode_338 {

    private int findBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) count++;
            n >>= 1;
        }
        return count;
    }

    public int[] countingBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] += findBits(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Leetcode_338 o = new Leetcode_338();
        int[] nums = o.countingBits(16);
        System.out.println(Arrays.toString(nums));
    }
}
