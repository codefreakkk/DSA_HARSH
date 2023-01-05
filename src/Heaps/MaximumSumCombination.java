package Heaps;

import java.util.*;

public class MaximumSumCombination {

    class Tupple {
        int data, indexA, indexB;
        public Tupple(int data, int indexA, int indexB) {
            this.data = data;
            this.indexA = indexA;
            this.indexB = indexB;

        }
    }

    public List<Integer> maxCombination(int k, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int size = a.length;
        PriorityQueue<Tupple> pq = new PriorityQueue<>(new Comparator<Tupple>(){
            public int compare(Tupple t1, Tupple t2) {
                return t2.data - t1.data;
            }
        });

        for (int i = 0; i < size; i++) {
            int addition = a[i] + b[size - 1];
            pq.offer(new Tupple(addition, i, size - 1));
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && k-- != 0) {
            Tupple tupple = pq.poll();
            int data = tupple.data;
            int x = tupple.indexA;
            int y = tupple.indexB;
            ans.add(data);

            if (y != 0) {
                int addition = a[x] + b[y - 1];
                pq.offer(new Tupple(addition, x, y - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumSumCombination o = new MaximumSumCombination();
        int k = 2;
        int[] a = {3, 2};
        int[] b = {1, 4};
        List<Integer> ans = o.maxCombination(k, a, b);
        System.out.println(ans);
    }
}
