package POTD_LEETCODE;

public class CountNicePairsInAnArray {

    private static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = (rev * 10) + rem;
            num /= 10;
        }
        return rev;
    }

    public static int countNicePairs(int[] nums) {
        int ans = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum1 = nums[i] - reverse(nums[i]);
                int sum2 = nums[j] - reverse(nums[j]);
                if (sum1 == sum2) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {13,10,35,24,76};
        System.out.println(countNicePairs(nums));
    }
}
