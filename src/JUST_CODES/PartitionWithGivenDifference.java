package JUST_CODES;

public class PartitionWithGivenDifference {

    private static int solve(int[] nums, int index, int sum, int totalSum, int d) {
        if (index >= nums.length) return 0;
        if (Math.abs((totalSum - sum) - sum) == d) {
            return 1;
        }
        int notPick = solve(nums, index + 1, sum, totalSum, d);
        int pick = solve(nums, index + 1, sum + nums[index], totalSum, d);

        return notPick + pick;
    }

    public static int countPartitions(int n, int d, int[] nums) {
        int sum = 0;
        for (int it : nums) sum += it;

        return solve(nums, 0,0, sum, d);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 5, 1};
        int d = 1;
        System.out.println(countPartitions(nums.length, d, nums));
    }
}
