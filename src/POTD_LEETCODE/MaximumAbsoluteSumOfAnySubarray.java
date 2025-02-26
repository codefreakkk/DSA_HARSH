package POTD_LEETCODE;

public class MaximumAbsoluteSumOfAnySubarray {

    public int maxAbsSum(int[] nums) {
        int negativeSum = 0, positiveSum = 0;
        int negativeAns = 0, positiveAns = 0;

        for (int it : nums) {
            negativeSum += it;
            positiveSum += it;

            if (negativeSum > 0) {
                negativeSum = 0;
            } else {
                negativeAns = Math.max(negativeAns, Math.abs(negativeSum));
            }

            if (positiveSum < 0) {
                positiveSum = 0;
            } else {
                positiveAns = Math.max(positiveAns, Math.abs(positiveSum));
            }
        }
        return Math.max(negativeAns, positiveAns);
    }

    public static void main(String[] args) {

    }
}
