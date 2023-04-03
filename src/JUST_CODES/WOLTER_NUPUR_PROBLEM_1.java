package JUST_CODES;
import java.util.*;

public class WOLTER_NUPUR_PROBLEM_1 {

    private static int solve(int index, int take, int[] nums, int k, List<Integer> list, int[][] dp) {
        if (index == nums.length) return 0;
        if (dp[index][take] != -1) return dp[index][take];

        int notPick = solve(index + 1, 0, nums, k, list, dp);
        int pick = 0;
        if (list.size() < k) {
            list.add(nums[index]);
            pick = 1 + solve(index + 1, 1, nums, k, list, dp);
            list.remove(list.size() - 1);
        }
        return (pick + notPick) % 10000;
    }

    public static int getUniqueFalvours(int n, int k) {
        int[] nums = new int[n];
        List<Integer> list = new ArrayList<>();

        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) Arrays.fill(row, -1);

        for (int i = 0; i < n; i++) nums[i] = i;
        return solve(0, 0, nums, k, list, dp);
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(getUniqueFalvours(n, k));
    }
}
