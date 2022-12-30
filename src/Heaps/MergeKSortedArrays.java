package Heaps;

import java.util.*;

class Tupple {
    int data, row, col;
    public Tupple(int data, int row, int col) {
        this.data = data;
        this.row = row;
        this.col = col;
    }
}

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(int[][] nums, int k) {
        PriorityQueue<Tupple> pq = new PriorityQueue<>(new Comparator<Tupple>() {
            @Override
            public int compare(Tupple o1, Tupple o2) {
                return o1.data - o2.data;
            }
        });

        // push first element of k arrays
        for (int i = 0; i < k; i++)
            pq.offer(new Tupple(nums[i][0], i, 0));

        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Tupple tupple = pq.poll();
            ans.add(tupple.data);

            int row = tupple.row;
            int col = tupple.col;

            if (col + 1 < nums[row].length)
                pq.offer(new Tupple(nums[row][col + 1], row, col + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        int k = 3;
        ArrayList<Integer> list = mergeKSortedArrays(nums, k);
        System.out.println(list);
    }
}
