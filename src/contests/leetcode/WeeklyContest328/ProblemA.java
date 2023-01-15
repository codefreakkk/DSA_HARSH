package contests.leetcode.WeeklyContest328;

public class ProblemA {
    public static int difference(int[] nums) {
        int element = 0, digit = 0;

        for (int num : nums) {
            element += num;
            if (num > 9) {
                int rem = 0;
                while (num > 0) {
                    rem = num % 10;
                    digit += rem;
                    num /= 10;
                }
            }
            else
                digit += num;
        }
        return Math.abs(element - digit);
    }

    public static void main(String[] args) {
        int[] nums = {1, 15, 6, 3};
        System.out.println(difference(nums));
    }
}
