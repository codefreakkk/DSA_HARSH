package Heaps;

import java.util.PriorityQueue;

public class HandsOfStraight {
    public static boolean isNStrightHand(int[] hand, int groupSize) {
        int size = hand.length;
        if (size % groupSize != 0)
            return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++)
            pq.offer(hand[i]);

        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(current + i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
