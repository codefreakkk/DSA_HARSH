package leetcodeContest.WeeklyContest327;

public class ProblemA {
    public int maximumCount(int[] nums) {
        int positiveCount = 0, negativeCount = 0;

        for (int num : nums) {
            if (num < 0)
                negativeCount++;
            else if (num > 0)
                positiveCount++;
        }
        return Math.max(positiveCount, negativeCount);
    }
    public static void main(String[] args) {

    }
}
