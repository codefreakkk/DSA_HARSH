package RANDOM_PROBLEM;

import java.util.Arrays;

public class MasterCardProblem1 {

    public static long solve(int[] arr, int n, int m, int k) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if(arr[i]%m==0)
                {
                    count++;
                    break;
                }
                arr[i] += j;
                if(arr[i]%m==0)
                {
                    k -= j;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {17, 8, 9, 1, 4};
        System.out.println(solve(nums, nums.length, 4, 3));
    }
}
