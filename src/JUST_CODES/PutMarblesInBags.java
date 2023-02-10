package JUST_CODES;
import java.util.*;

// greedy approach
public class PutMarblesInBags {
    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        List<Integer> list = new ArrayList<>();

        // base case
        if (n == 0 || k == n) return 0;

        for (int i = 0; i < n - 1; i++)
            list.add(weights[i] + weights[i + 1]);

        Collections.sort(list);

        long min = 0, max = 0;

        for (int i = 0; i < k - 1; i++) {
            min += list.get(i);
            max += list.get(list.size() - 1 - i);
        }
        return max - min;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 1};
        int k = 2;
        System.out.println(putMarbles(nums, k));
    }
}
