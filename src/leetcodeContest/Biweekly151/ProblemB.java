package leetcodeContest.Biweekly151;
import java.util.*;

public class ProblemB {

    private int findElement(int start, int end, int offset, int target) {
        System.out.println(start + " " + end + " " + offset + " " + target);
        int count = 0;
        for (int i = 0; i < end; i++) {
            if (target == Math.abs(start - offset)) {
                count++;
            }
            System.out.print("Count " + count + " ");
            start++;
            offset++;
        }
        System.out.println();
        return count;
    }

    public int countArrays(int[] nums, int[][] bounds) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(nums[i] - nums[i - 1]);
        }

        System.out.println(list);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int start = Math.min(bounds[i][0], bounds[i - 1][0]);
            int limit1 = bounds[i][1] - bounds[i][0] + 1;
            int limit2 = bounds[i - 1][1] - bounds[i - 1][0] + 1;
            int end = Math.min(limit2, limit1);
            int offset = Math.max(bounds[i][0], bounds[i - 1][0]);
            System.out.println(end);
            int ele = findElement(start, end, offset, list.get(i - 1));
            System.out.println("ele = " + ele);
            ans = Math.min(ans, ele);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {11, 42};
        int[][] bounds = {{22, 55}, {72, 110}};
        ProblemB o = new ProblemB();
        System.out.println(o.countArrays(nums, bounds));
    }
}
