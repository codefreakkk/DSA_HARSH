package REVISION.recursion_2;

public class CheckArraySorted {

    public static boolean solve(int prevIndex, int index, int[] nums) {
        if (index == nums.length - 1) {
            if (nums[index] > nums[prevIndex]) {
                return true;
            }
            return false;
        }
        if (nums[index] > nums[prevIndex]) {
            return solve(prevIndex + 1, index + 1, nums);
        } else {
            return false;
        }
    }

    public static boolean sortedArray(int[] nums) {
        return solve(0, 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 2, 7};
        boolean ans = CheckArraySorted.sortedArray(nums);
        System.out.println(ans);
    }

}
