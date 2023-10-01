package leetcodeContest.WeeklyContest365;

// problem not solved
public class ProblemB {

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0, c = 0, index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                a = Math.max(a, nums[i]);
                index = i + 1;
            }
        }
        b = nums[index];
        c = b == n - 1 ? 0 : nums[n - 1];

        long ans = (long) (a - b) * c;
        if (ans < 0) return 0;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(maximumTripletValue(nums));
    }
}

//Input:
//        [8,6,3,13,2,12,19,5,19,6,10,11,9]
//        Output:
//        0
//        Expected:
//        266