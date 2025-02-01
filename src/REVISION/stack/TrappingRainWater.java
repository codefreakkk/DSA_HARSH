package REVISION.stack;

public class TrappingRainWater {

    public int trap(int[] nums) {
        int total = 0, leftMax = -1, rightMax = -1;
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (nums[i] <= nums[j]) {
                if (nums[i] <= leftMax) {
                    total += leftMax - nums[i];
                } else {
                    leftMax = nums[i];
                }
                i++;
            } else {
                if (nums[j] <= rightMax) {
                    total += rightMax - nums[j];
                } else {
                    rightMax = nums[j];
                }
                j--;
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }

}
