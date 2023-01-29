package contests.leetcode.WeeklyContest330;

import java.util.*;

public class ProblemA {
    public static int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i = 2; i < num; i++) {
                if (num % i == 1) queue.offer(i);
            }
            set.add(num);
        }
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(distinctIntegers(3));
    }
}
