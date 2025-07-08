package DSA_REVISION.heaps;

import java.util.*;

public class MinCostRopes {

    public int minCost(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int it : nums) {
            pq.offer(it);
        }

        int ans = 0;

        while (!pq.isEmpty() && pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            ans += (num1 + num2);
            pq.offer(num1 + num2);
        }
        return ans;
    }
}
