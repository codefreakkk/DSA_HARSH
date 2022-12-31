package Heaps;

import java.util.*;

public class ReorganizingString {
    class Pairs {
        char data;
        int frequency;
        public Pairs(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
        }
    }

    public String reorganizingString(String s) {
        PriorityQueue<Pairs> pq = new PriorityQueue<>(new Comparator<Pairs>() {
            @Override
            public int compare(Pairs p1, Pairs p2) {
                return p2.frequency - p1.frequency;
            }
        });
        HashMap<Character, Integer> map = new HashMap<>();

        // count frequency of all characters
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // push map values in maxheap
        for (Map.Entry<Character, Integer> mp : map.entrySet())
            pq.offer(new Pairs(mp.getKey(), mp.getValue()));



        String ans = "";
        while (pq.size() > 1) {
            Pairs top1 = pq.poll();
            ans += top1.data;

            Pairs top2 = pq.poll();
            ans += top2.data;

            top1.frequency--;
            if (top1.frequency > 0)
                pq.offer(top1);

            top2.frequency--;
            if (top2.frequency > 0)
                pq.offer(top2);
        }

        if (!pq.isEmpty()) {
            if (pq.peek().frequency > 1)
                return "";
            else
                ans += pq.peek().data;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReorganizingString o = new ReorganizingString();
        String s = "vvvlo";
        String ans = o.reorganizingString(s);
        System.out.println(ans);
    }
}
