package COMPANY_PROBLEMS;
import java.util.*;

public class JumpGame3 {

    class Pair {
        int index, value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public boolean canReach(int[] nums, int start) {
        int n = nums.length;

        int[] visited = new int[n];
        visited[start] = 1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, nums[start]));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int index = pair.index;
            int value = pair.value;

            if (value == 0) return true;

            int leftIndex = index - value;
            int rightIndex = index + value;

            if (leftIndex > 0 && visited[leftIndex] == 0) {
                queue.offer(new Pair(leftIndex, nums[leftIndex]));
                visited[leftIndex] = 1;
            }

            if (rightIndex < n && visited[rightIndex] == 0) {
                queue.offer(new Pair(rightIndex, nums[rightIndex]));
                visited[rightIndex] = 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        JumpGame3 o = new JumpGame3();
        int[] nums = {4,2,3,0,3,1,2};
        int start = 0;
        System.out.println(o.canReach(nums, start));
    }
}
