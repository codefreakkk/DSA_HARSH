package Heaps;

import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i : map.values())
            pq.offer(i);

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            int timer = 0;

            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    queue.offer(pq.poll() - 1);
                    timer++;
                }
            }
            while (!queue.isEmpty()) {
                int element = queue.poll();
                if (element != 0)
                    pq.offer(element);
            }
            result += pq.isEmpty() ? timer : n + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
