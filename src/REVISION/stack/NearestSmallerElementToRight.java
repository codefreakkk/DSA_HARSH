package REVISION.stack;

import java.util.*;

public class NearestSmallerElementToRight {

    public static ArrayList<Integer> nearestSmallerElementToRight(int[] nums, int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            while (stack.peek() >= num) {
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(num);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(NearestSmallerElementToRight.nearestSmallerElementToRight(nums, nums.length));
    }

}
