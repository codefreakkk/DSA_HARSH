package JUST_CODES;

import java.util.*;

public class MSCI_PROBLEM_1 {
    static int
    countSubArrayProductLessThanK(int[] a,
                                  long k)
    {
        int n = a.length;
        long p = 1;
        int res = 0;
        for (int start = 0, end = 0; end < n; end++) {
            p *= a[end];
            while (start < end && p >= k)
                p /= a[start++];

            if (p < k) {
                int len = end - start + 1;
                res += len;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(countSubArrayProductLessThanK(nums, 6));
    }
}
