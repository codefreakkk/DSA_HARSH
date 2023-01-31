package Greedy;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < tasks.length; i++)
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);

        for (int val : map.values()) pq.offer(val);

        int result = 0;
        while (!pq.isEmpty()) {
            int timer = 0;

            for (int i = 0; i < n  + 1; i++) {
                if (!pq.isEmpty()) {
                    queue.offer(pq.poll() - 1);
                    timer++;
                }
            }
            while (!queue.isEmpty()) {
                int element = queue.poll();
                if (element != 0) pq.offer(element);
            }
            result += pq.isEmpty() ? timer : n + 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
