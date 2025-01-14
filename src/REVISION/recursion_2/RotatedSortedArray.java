package REVISION.recursion_2;

public class RotatedSortedArray {

    private int solve(int start, int end, int target, int[] nums) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start]  && target < nums[mid]) {
                return solve(start, mid - 1, target, nums);
            } else {
                return solve(mid + 1, end, target, nums);
            }
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                return solve(mid + 1, end, target, nums);
            } else {
                return solve(start, mid - 1, target, nums);
            }
        }
    }

    public int search(int[] nums, int target) {
        return solve(0, nums.length - 1, target, nums);
    }

    public static void main(String[] args) {
        RotatedSortedArray obj = new RotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(obj.search(nums, 0));
    }

}
