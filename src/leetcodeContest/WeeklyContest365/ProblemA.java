package leetcodeContest.WeeklyContest365;

public class ProblemA {

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long value = (long) (nums[i] - nums[j]) * nums[k];
                    if (value < 0) {
                        continue;
                    }
                    ans = Math.max(ans, value);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1000000,1,1000000};
        System.out.println(maximumTripletValue(nums));
    }
}

