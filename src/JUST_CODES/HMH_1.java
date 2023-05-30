package JUST_CODES;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HMH_1 {

    private int mod = (int) 1e9+7;

    private int process(int[] temp, int k, int index) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) pq.offer(temp[i]);

        temp[index] += pq.poll();

        int sum = 0;
        for (int i = 0; i < k; i++) sum += temp[i];
        return sum % mod;
    }

    public int[] getMaxScore(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int k = 0; k < n; k++) {
            int max = Integer.MIN_VALUE;

            // create temp array
            int[] temp = new int[k + 1];
            for (int index = 0; index < k + 1; index++) temp[index] = nums[index];

            for (int i = 0; i < k + 1; i++) {
                max = Math.max(process(temp, k + 1, i), max);
            }
            ans[k] = max;
        }
        return ans;
    }

    public static void main(String[] args) {
        HMH_1 o = new HMH_1();
        int[] nums = {5, 1, 4, 2};
        System.out.println(Arrays.toString(o.getMaxScore(nums)));
    }
}
