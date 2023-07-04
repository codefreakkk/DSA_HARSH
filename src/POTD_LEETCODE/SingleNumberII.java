package POTD_LEETCODE;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int e : nums) {
            ones = (ones ^ e) & (~twos);
            twos = (twos ^ e) & (~ones);
        }
        return ones;
    }

    public static void main(String[] args) {

    }
}
