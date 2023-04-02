package DynamicProgramming;
import java.util.*;

public class LongestIncreasingSubsequenceBinarySearch {

    private int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = list.get(mid);

            if (val == target) return mid;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) list.add(nums[i]);
            else {
                int index = upperBound(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {

    }
}
