package Heaps;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequentElements(int[] nums, int k) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // store frequency
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            pq.offer(new int[]{mp.getKey(), mp.getValue()});
            if (pq.size() > k)
                pq.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = pq.poll()[0];

        return result;
    }

    public static void main(String[] args) {
    }
}
