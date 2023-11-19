package POTD_LEETCODE;
import java.util.*;

public class ReductionOperationsToMakeArrayElementsEqual {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, current = 0, ans = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                current++;
            }
            ans += current;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
