package REVISION.stack;
import java.util.*;

public class NearestGreaterElementToRight {

    public ArrayList<Integer> nearestGreaterIntegerElementToRight(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            while (stack.peek() != -1 && stack.peek() <= num) {
                stack.pop();
            }
            ans.add(stack.peek());
            stack.push(num);
        }
        Collections.reverse(ans);
        return ans;
    }

}
