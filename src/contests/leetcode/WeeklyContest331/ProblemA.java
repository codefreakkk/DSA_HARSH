package contests.leetcode.WeeklyContest331;
import java.util.*;
public class ProblemA {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : gifts) pq.offer(num);

        while (k-- > 0) {
            int num = pq.poll();
            int sqrt = (int) Math.floor(Math.sqrt(num));
            pq.offer(sqrt);
        }

        long ans = 0;
        while (!pq.isEmpty())
            ans += pq.poll();

        return ans;
    }
    public static void main(String[] args) {
        int[] num = {25, 64, 9, 4, 100};
        int k = 4;
        System.out.println(pickGifts(num, k));
    }
}
