package JUST_CODES;

import java.util.*;

public class IPO {
    class Pair {
        int profit, w;
        public Pair(int profit, int w) {
            this.profit = profit;
            this.w = w;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < profits.length; i++)
            pq.offer(new Pair(profits[i], capital[i]));

        while (k > 0 && !pq.isEmpty()) {
            Pair pair = pq.poll();
            if (pair.w <= w) {
                k--;
                w += pair.profit;
                while (!queue.isEmpty())
                    pq.offer(queue.poll());
            }
            else queue.offer(pair);
        }
        return w;
    }

    public static void main(String[] args) {
        IPO o = new IPO();
        int[] profit = {1,2,3};
        int[] capital = {0, 1, 1};
        int k = 2, w = 0;
        System.out.println(o.findMaximizedCapital(k, w, profit, capital));
    }
}
