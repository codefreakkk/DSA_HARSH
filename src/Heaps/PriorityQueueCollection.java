package Heaps;

import java.util.*;

public class PriorityQueueCollection {
    public static void main(String[] args) {
        // min heap priority queue
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        // max heap priority queue
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        maxheap.offer(5);
        maxheap.offer(1);
        maxheap.offer(2);
        while (!maxheap.isEmpty())
            System.out.println(maxheap.poll());
    }
}
