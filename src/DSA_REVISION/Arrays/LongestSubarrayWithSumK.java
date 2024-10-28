package DSA_REVISION.Arrays;
import java.util.*;

public class LongestSubarrayWithSumK {

    public int lengthOfLongestSubarrayWithSumK(int[] nums, int k, int N) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, maxLength = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            int remaining = sum - k;
            if (map.containsKey(remaining)) {
                maxLength = Math.max(maxLength, i - map.get(remaining));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}
