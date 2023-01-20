package JUST_CODES;

import java.util.Collections;
import java.util.PriorityQueue;

public class NVDIA_PROBLEM_A {
    public static int getStone(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums)
            pq.offer(i);

        while (!pq.isEmpty()) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int ans = Math.abs(stone2 - stone1);
            if (ans != 0) {
                pq.offer(ans);
            }
            if (pq.size() == 1)
                return pq.peek();
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 7, 7};
        System.out.println(getStone(nums));
    }
}
