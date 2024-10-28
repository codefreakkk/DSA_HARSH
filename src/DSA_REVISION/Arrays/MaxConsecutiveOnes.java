package DSA_REVISION.Arrays;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, ans = 0;
        for (int num : nums) {
            if (num == 0) {
                ans = Math.max(ans, max);
                max = 0;
            }
            else {
                max++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
