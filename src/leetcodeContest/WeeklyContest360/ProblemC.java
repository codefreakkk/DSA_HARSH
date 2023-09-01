package leetcodeContest.WeeklyContest360;
import java.util.*;

public class ProblemC {

    public int minOperations(List<Integer> nums, int target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        for (int it : nums) {
            pq.offer(it);
            sum += it;
        }


        int ans = 0;
        while (target > 0) {
            int front = pq.poll();
            sum -= front;

            if (front <= target) {
                target -= front;
            }
            else if (front > target && sum < target) {
                ans++;
                sum += front;

                int divide = front / 2;
                pq.offer(divide);
                pq.offer(divide);
            }
            if (pq.isEmpty() && target != 0) {
                return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
