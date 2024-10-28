package DSA_REVISION.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int  n = nums.length, xor1 = 0, xor2 = 0;

        for (int i = 0; i < n; i++) {
            xor1 ^= nums[i];
            xor2 = xor2 ^ (i + 1);
        }
        return xor1 ^ xor2;

    }

    public static void main(String[] args) {

    }
}
