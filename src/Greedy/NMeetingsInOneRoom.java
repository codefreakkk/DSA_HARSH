package Greedy;

import java.util.*;

// activity selection algo

public class NMeetingsInOneRoom {
    class Pair implements Comparable<Pair> {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair pair) {
            return this.end - pair.end;
        }
    }

    public int maxMeetings(int[] start, int[] end, int n) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Pair(start[i], end[i]));

        Collections.sort(list);

        int count = 1;
        int endTime = list.get(0).end;
        for (int i = 1; i < n; i++) {
            if (list.get(i).start > endTime) {
                endTime = list.get(i).end;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
