package Greedy;

import java.util.*;

public class MaximumNumberOfEventsThatCanBeAttend {
    class Pair implements Comparable<Pair> {
        int startDay, endDay;
        public Pair(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }

        public int compareTo(Pair pair) {
            return this.startDay - pair.startDay;
        }
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Pair> list = new ArrayList<>();
        for (int[] event : events) list.add(new Pair(event[0], event[1]));
        Collections.sort(list);

        int i = 0, d = 0, result = 0;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty()) d = list.get(i).startDay;
            while (i < n && list.get(i).startDay <= d) {
                pq.offer(list.get(i++).endDay);
            }
            pq.poll();
            result++;
            d++;
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumNumberOfEventsThatCanBeAttend o = new MaximumNumberOfEventsThatCanBeAttend();
        int[][] events = {
                {1, 10},{2, 2},{2,2},{2,2},{2,2}
        };
        System.out.println(o.maxEvents(events));
    }
}
