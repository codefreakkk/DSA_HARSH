package REVISION.stack;
import java.util.*;

public class FirstNegativeInEveryWindowSizeK {

    public List<Integer> firstNegativeInteger(int[] nums, int k) {
        int n = nums.length;

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] < 0) {
                queue.offer(nums[j]);
            }

            if (j - i + 1 == k) {
                if (queue.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(queue.peek());
                    if (queue.peek() == nums[i]) {
                        queue.poll();
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

