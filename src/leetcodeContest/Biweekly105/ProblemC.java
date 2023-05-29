package leetcodeContest.Biweekly105;

public class ProblemC {

    private long ans = Integer.MIN_VALUE;

    public void solve(int[] nums, int index, long result) {
        if (index >= nums.length) {
            ans = Math.max(ans, result);
            return;
        }

        solve(nums, index + 1, result * nums[index]);
        solve(nums, index + 1, result);
    }

    public long maxStrength(int[] nums) {
        solve(nums, 0, 1);
        return ans;
    }

    public static void main(String[] args) {
        ProblemC o = new ProblemC();
        int[] nums = {-4, -5, -4};
        System.out.println(o.maxStrength(nums));
    }
}
