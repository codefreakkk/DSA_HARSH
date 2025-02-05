package REVISION.stack;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> queue = new LinkedList<>();

        int i = 0, j = 0, index = 0;
        while (j < n) {
            while (!queue.isEmpty() && queue.peekLast() <= nums[j]) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);

            int window = j - i + 1;
            if (window < k) j++;
            else if (window == k) {
                ans.add(queue.peekFirst());
                if (queue.peekFirst() == nums[i]) {
                    queue.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

}
