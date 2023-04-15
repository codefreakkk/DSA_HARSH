package leetcodeContest.Biweekly102;
import java.util.*;

public class ProblemB {

    public static long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        ans[0] = nums[0];

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer((long) nums[0]);

        long prefix = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) pq.offer((long) nums[i]);
            long conv = pq.peek() + nums[i];
            prefix += conv;
            ans[i] = prefix;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,4,8,16};
        System.out.println(Arrays.toString(findPrefixScore(nums)));
    }
}
