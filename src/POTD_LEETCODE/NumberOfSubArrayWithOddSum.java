package POTD_LEETCODE;

public class NumberOfSubArrayWithOddSum {

    public int numOfSubarray(int[] nums) {
        int n = nums.length;
        int sum = 0, odd = 0, even = 1, ans = 0;

        for (int it : nums) {
            sum += it;
            if (sum % 2 == 1) {
                odd++;
                ans += even + 1;
            } else {
                even++;
                ans += odd;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
