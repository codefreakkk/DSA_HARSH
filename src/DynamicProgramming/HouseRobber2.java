package DynamicProgramming;

import java.util.*;

public class HouseRobber2 {

    private int solve(List<Integer> nums) {
        int prev = nums.get(0), prev2 = 0;
        int n = nums.size();

        for (int i = 1; i < n; i++) {
            int pick = nums.get(i);
            if (i > 1) pick += prev2;
            int notPick = prev;
            int current = Math.max(pick, notPick);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        List<Integer> first = new ArrayList<>();
        List<Integer> last = new ArrayList<>();

        for (int i = 0; i < n - 1; i++)
            first.add(nums[i]);

        for (int i = 1; i < n; i++)
            last.add(nums[i]);

        return Math.max(solve(first), solve(last));
    }

    public static void main(String[] args) {
        HouseRobber2 o= new HouseRobber2();
        int[] nums = {2, 3, 2};
        System.out.println(o.rob(nums));
    }
}
