package Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int boundary = 0;
        for (int i = 0; i <= boundary; i++) {
            boundary = Math.max(boundary, i + nums[i]);
            if (boundary >= nums.length - 1) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        JumpGame o = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(o.canJump(nums));
    }
}
