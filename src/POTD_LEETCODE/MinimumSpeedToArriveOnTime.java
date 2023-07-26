package POTD_LEETCODE;

import java.util.Arrays;

public class MinimumSpeedToArriveOnTime {

    private boolean check(int speed, double hour, int[] nums) {
        double sum = 0.0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            double time = (double) nums[i] / speed;
            sum += (i == n - 1) ? time : Math.ceil(time);
        }
        return sum <= hour;
    }

    public int minSpeedOnTime(int[] nums, double hour) {
        int low = 1, high = (int) 1e7;

        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid, hour, nums)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        MinimumSpeedToArriveOnTime o = new MinimumSpeedToArriveOnTime();
        int[] nums = {1, 3, 2};
        double hours = 1.9;
        System.out.println(o.minSpeedOnTime(nums, hours));
    }
}
