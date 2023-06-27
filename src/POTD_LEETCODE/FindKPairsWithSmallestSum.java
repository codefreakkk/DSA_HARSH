package POTD_LEETCODE;

import java.util.*;

public class FindKPairsWithSmallestSum {

    class Tupple {
        int data, i, j;
        public Tupple(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        PriorityQueue<Tupple> pq = new PriorityQueue<>((a, b) -> b.data - a.data);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int addition = nums1[i] + nums2[j];
                if (pq.size() < k) {
                    pq.offer(new Tupple(addition, i, j));
                }
                else {
                    pq.offer(new Tupple(addition, i, j));
                    pq.poll();
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Tupple tupple = pq.poll();
            ans.add(Arrays.asList(tupple.i, tupple.j));
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
