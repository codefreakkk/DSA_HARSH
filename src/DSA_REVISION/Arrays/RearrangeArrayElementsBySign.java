package DSA_REVISION.Arrays;
import java.util.*;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (num > 0) {
                queue.offer(num);
            }
        }
        int index = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                ans[index++] = queue.poll();
                ans[index++] = nums[i];
            }
        }
        return ans;
    }
}
