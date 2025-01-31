package REVISION.stack;
import java.util.Stack;


public class CelebrityProblem {

    public int celebrity(int[][] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty() && stack.size() != 1) {
            int element1 = stack.pop();
            int element2 = stack.pop();

            if (nums[element1][element2] == 1) {
                stack.push(element2);
            } else if (nums[element2][element1] == 1) {
                stack.push(element1);
            }
        }

        if (stack.isEmpty()) {
            return -1;
        }

        int index= stack.pop();
        for (int i = 0; i < n; i++) {
            if (nums[index][i] == 1) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i][index] == 0 && i != index) {
                return -1;
            }
        }
        return index;
    }


}
