package Greedy;

import java.util.*;

public class MinimumCostOfRopes {
    public long minCost(long[] arr, int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : arr) pq.offer(num);

        int ans = 0;
        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            ans += num1 + num2;
            pq.offer(num1 + num2);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
