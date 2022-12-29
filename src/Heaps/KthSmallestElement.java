package Heaps;

import java.util.*;

public class KthSmallestElement {
    public static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++)
            pq.offer(arr[i]);

        int size = arr.length;
        for (int i = k; i < size; i++) {
            int current = arr[i];
            if (current < pq.peek()) {
                pq.poll();
                pq.offer(current);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallestElement(arr, k));
    }
}
