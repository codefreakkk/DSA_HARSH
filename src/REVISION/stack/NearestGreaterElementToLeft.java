package REVISION.stack;
import java.util.*;

public class NearestGreaterElementToLeft {

    public static ArrayList<Integer> nearestGreaterElementToLeft(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (stack.peek() != -1 && stack.peek() <= num) {
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 4};
        System.out.println(NearestGreaterElementToLeft.nearestGreaterElementToLeft(nums));
    }
}
