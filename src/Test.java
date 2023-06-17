import java.util.*;

public class Test {

    private static int getUpperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 4};
        System.out.println(getUpperBound(nums, 4));
    }
}
