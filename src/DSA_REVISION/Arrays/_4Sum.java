package DSA_REVISION.Arrays;
import java.util.*;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length, j = 1;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            int sum = -(nums[i] + nums[j]);
            int low = j + 1, high = n - 1;

            while (low < high) {
                if (nums[low] + nums[high] == (target - sum)) {
                    ans.add(List.of(nums[i], nums[j], nums[low], nums[high]));

                    while (low < n && nums[low] == nums[low]) {
                        low++;
                    }

                    while (high > j && nums[high] == nums[high - 1]) {
                        high--;
                    }
                }
                else if (nums[low] + nums[high] < target) {
                    low++;
                }
                else {
                    high--;
                }
            }
            while (j < n - 2 && nums[j] == nums[j + 1]) {
                j++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
