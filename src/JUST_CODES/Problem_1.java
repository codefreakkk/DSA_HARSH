package JUST_CODES;
import leetcodeContest.Biweekly111.ProblemC;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_1 {


    void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void solve(int nums[], int index, List<Integer> output, List<List<Integer>> answer) {
        if(index >= nums.length - 1) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            solve(nums, index + 1, output, answer);
            swap(nums, i, index);
        }
    }

    public int findLuckyArrangements(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> permutations = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), permutations);

        int ans = 0;
        for (List<Integer> it : permutations) {

            int count = 0;
            for (int i = 0; i < it.size(); i++) {
                if ((((i + 1) % it.get(i)) == 0) || (it.get(i) % (i + 1)) == 0) {
                    count++;
                }
            }
            if (count == n) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem_1 o = new Problem_1();
        System.out.println(o.findLuckyArrangements(3));
    }
}
