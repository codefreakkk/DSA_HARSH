package ALGOS.MEET_IN_THE_MIDDLE;
import java.util.*;

public class ClosestSubsequence {

    private List<Integer> getSubsetSum(int start, int end, int offset, int[] nums) {
        int n = end - start + 1;
        List<Integer> subsets = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) > 0) {
                    sum += nums[j + offset];
                }
            }
            subsets.add(sum);
        }
        return subsets;
    }

    private int getMinDifference(List<Integer> firstHalf, List<Integer> secondHalf, int target) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < firstHalf.size(); i++) {
            int num = firstHalf.get(i);
            int low = 0, high = secondHalf.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int sum = num + secondHalf.get(mid);

                if (sum == target) {
                    return 0;
                }
                else if (sum < target) {
                    max = Math.max(max, sum);
                    low = mid + 1;
                }
                else {
                    min = Math.min(min, sum);
                    high = mid - 1;
                }
            }
        }
        int ans = Math.min(Math.abs(max - target), Math.abs(target - min));
        return ans;
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;

        List<Integer> firstHalf = getSubsetSum(0, n / 2 - 1, 0, nums);
        List<Integer> secondHalf = getSubsetSum(n / 2, n - 1, n / 2, nums);
        Collections.sort(secondHalf);

        return getMinDifference(firstHalf, secondHalf, goal);
    }


    public static void main(String[] args) {

    }
}
