package leetcodeContest.WeeklyContest327;

import java.util.*;

public class ProblemB {
    public static long maxKElements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int size = nums.length;

        // add elements into priority queue
        for (int i = 0; i < size; i++)
            pq.offer(nums[i]);

        long answer = 0;
        for (int i = 0; i < k; i++) {
            int current = pq.poll();
            answer += current;

            double value = (double) current / 3;
            pq.offer((int) Math.ceil(value));
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {10,10,10,10,10};
        int k = 5;
        System.out.println(maxKElements(nums, k));
    }
}
