package Heaps;

import java.util.*;

public class ReplaceElementsByRanksInArray {
    class Pairs {
        int data, index;
        public Pairs(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    class SortByValue implements Comparator<Pairs> {
        @Override
        public int compare(Pairs p1, Pairs p2) {
            return p1.data - p2.data;
        }
    }


    public int[] replaceWithRank(int[] nums, int n) {
        PriorityQueue<Pairs> pq = new PriorityQueue<>(new SortByValue());
        for (int i = 0; i < n; i++)
            pq.offer(new Pairs(nums[i], i));

        int rank = 0, prev = -1;
        while (!pq.isEmpty()) {
            Pairs pair = pq.poll();
            int data = pair.data;
            int index = pair.index;

            if (prev == data) {
                nums[index] = rank;
            }
            else
                nums[index] = ++rank;

            prev = data;
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
