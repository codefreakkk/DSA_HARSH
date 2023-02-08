package Greedy;


public class JumpGame2 {
    private int min = Integer.MAX_VALUE;
    // TLE using recursion
    private void solve(int[] nums, int num, int level, int index) {
        if (num == 0) {
            if (index == nums.length - 1)
                min = Math.min(min, level);

            return;
        }
        if (index == nums.length - 1) {
            min = Math.min(min, level);
            return;
        }

        for (int i = 0; i < num; i++) {
            index++;
            if (index > nums.length - 1)
                return;

            solve(nums, nums[index], level + 1, index);
        }
    }

    public int jumpRecursion(int[] nums) {
        solve(nums, nums[0], 0, 0);
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }

    // iterative approach
    public static int jumpItreative(int[] nums) {
        if (nums.length == 1) return 0;
        int max = 0, current = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (current == i) {
                current = max;
                count++;
            }
            if (current >= nums.length - 1)
                return count;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpItreative(nums));
    }
}
