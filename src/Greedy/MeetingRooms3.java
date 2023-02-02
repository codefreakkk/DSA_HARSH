package Greedy;

import java.util.*;

public class MeetingRooms3 {
    class Pair {
        int room, end;
        public Pair(int end, int room) {
            this.end = end;
            this.room = room;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        PriorityQueue<Pair> busy = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.end == p2.end) return p1.room - p2.room;
                return p1.end - p2.end;
            }
        });
        int[] count = new int[n + 1];

        for (int i = 0; i < n; i++)
            rooms.offer(i);

        for (int[] m : meetings) {
            while (!busy.isEmpty() && busy.peek().end <= m[0]) {
                rooms.offer(busy.peek().room);
                busy.poll();
            }
            int start = rooms.isEmpty() ? busy.peek().end : m[0];
            int r = rooms.isEmpty() ? busy.peek().room : rooms.peek();
            int duration = m[1] - m[0];

            if (rooms.isEmpty()) busy.poll();
            else rooms.poll();

            count[r]++;
            busy.offer(new Pair(start + duration, r));
        }

        int max = Integer.MIN_VALUE, index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MeetingRooms3 o = new MeetingRooms3();
        int[][] meetings = {
                {1, 20},{2, 10},{3, 5},{4, 9},{6, 8}
        };
        int n = 3;
        System.out.println(o.mostBooked(n, meetings));
    }
}
