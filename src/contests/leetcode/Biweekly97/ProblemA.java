package contests.leetcode.Biweekly97;

import java.util.*;

public class ProblemA {
    public static int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (num > 9) {
                int temp = num;
                Stack<Integer> stack = new Stack<>();
                while (temp > 0) {
                    int rem = temp % 10;
                    stack.push(rem);
                    temp /= 10;
                }
                while (!stack.isEmpty()) list.add(stack.pop());
            }
            else list.add(num);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {7, 1, 3, 9};
        System.out.println(Arrays.toString(separateDigits(nums)));
    }
}
