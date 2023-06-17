package POTD_LEETCODE;
import java.util.*;

public class MakeArrayStrictlyIncreasing {

    private final int MAX = (int) 1e9;

    private int getUpperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }

    private int solve(int[] arr1, int[] arr2, int index, int prev, Map<Integer, Map<Integer, Integer>> dp) {
        if (index == arr1.length) return 0;

        if (dp.containsKey(index) && dp.get(index).containsKey(prev)) {
            return dp.get(index).get(prev);
        }

        int ans = MAX;
        int upperBound = getUpperBound(arr2, prev);
        if (prev < arr1[index]) {
            ans = Math.min(ans, solve(arr1, arr2, index + 1, arr1[index], dp));
        }
        if (upperBound < arr2.length) {
            ans = Math.min(ans, solve(arr1, arr2, index + 1, arr2[upperBound], dp) + 1);
        }

        // store dp values
        Map<Integer, Integer> map = dp.getOrDefault(index, new HashMap<>());
        map.put(prev, ans);
        dp.put(index, map);

        return ans;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        int ans = solve(arr1, arr2, 0, Integer.MIN_VALUE, dp);
        return ans == MAX ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
