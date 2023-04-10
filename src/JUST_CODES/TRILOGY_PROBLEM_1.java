package JUST_CODES;

import java.util.*;

public class TRILOGY_PROBLEM_1 {

    private int bitCount(int num) {
        int count = 0;
        while (num > 0) {
                count += num & 1;
                num >>= 1;
        }
        return count;
    }

    private int getXOR(List<Integer> list) {
        int xor = 0;
        for (int it : list) xor ^= it;
        return xor;
    }

    private void solve(int index, int[] nums, List<Integer> temp, List<List<Integer>> subsequence ) {
        if (index == nums.length) {
            subsequence.add(new ArrayList<>(temp));
            return;
        }

        // not pick
        solve(index + 1, nums, temp, subsequence);

        // pick
        if (temp.size() == 0 || ((temp.get(temp.size() - 1) < nums[index]) && bitCount(getXOR(temp)) <= bitCount(nums[index]))) {
            temp.add(nums[index]);
            solve(index + 1, nums, temp, subsequence);
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }

    public int findXORSubsequence(int[] nums) {
        int n = nums.length;

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> subsequence = new ArrayList<>();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        solve(0, nums, temp, subsequence);

        Set<Integer> set = new HashSet<>();
        for (List<Integer> it : subsequence) {
            if (it.size() == 0) set.add(0);
            else if (it.size() == 1) set.add(it.get(0));
            else {
                int xor = 0;
                for (int val : it) xor ^= val;
                set.add(xor);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        TRILOGY_PROBLEM_1 o = new TRILOGY_PROBLEM_1();
        int[] nums = {11, 2, 5, 17};
        System.out.println(o.findXORSubsequence(nums));
    }
}
