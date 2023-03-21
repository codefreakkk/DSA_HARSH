package JUST_CODES;

public class NumberOfZeroFilledSubArrays {
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                ans += count;
            }
            else count = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(nums));
    }
}
