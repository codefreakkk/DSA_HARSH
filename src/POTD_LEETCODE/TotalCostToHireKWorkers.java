package POTD_LEETCODE;
import java.util.*;


// no need of pairs for this solution
// Do it without pairs
// Remove pair if you are visiting this solution again
public class TotalCostToHireKWorkers {

    static class Pair {
        int data, index;
        public Pair(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int ptr1 = 0, ptr2 = n - 1;

        PriorityQueue<Pair> left = new PriorityQueue<>((a, b) -> a.data - b.data);
        while (ptr1 < candidates) {
            left.offer(new Pair(costs[ptr1], ptr1));
            ptr1++;
        }
        ptr1--;

        PriorityQueue<Pair> right = new PriorityQueue<>((a, b) -> a.data - b.data);
        int temp = candidates;
        while (temp-- > 0 && ptr2 != ptr1) {
            right.offer(new Pair(costs[ptr2], ptr2));
            ptr2--;
        }
        ptr2++;

        int ans = 0;
        while (k > 0) {
            if (left.isEmpty() && !right.isEmpty()) {
                ans += right.poll().data;
            }
            else if (right.isEmpty() && !left.isEmpty()) {
                ans += left.poll().data;
            }
            else if (left.peek().data <= right.peek().data) {
                Pair pair = left.poll();

                int data = pair.data;
                int index = pair.index;

                ans += data;
                if (ptr1 + 1 != ptr2) {
                    left.offer(new Pair(costs[ptr1 + 1],index + 1));
                    ptr1++;
                }
            }

            else if (right.peek().data < left.peek().data) {
                Pair pair = right.poll();

                int data = pair.data;
                int index = pair.index;

                ans += data;
                if (ptr2 - 1 != ptr1) {
                    right.offer(new Pair(costs[ptr2 - 1], index - 1));
                    ptr2--;
                }
            }
            k--;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,4,1};
        int k = 3;
        int candidates = 3;
        System.out.println(totalCost(nums, k, candidates));
    }
}