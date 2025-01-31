package REVISION.stack;
import java.util.*;

public class NextGreaterElement1 {

    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int n1 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = n1 - 1; i >= 0; i--) {
            int num = nums2[i];

            while (stack.peek() != -1 && stack.peek() <= num) {
                stack.pop();
            }
            map.put(nums2[i], stack.peek());
            stack.push(num);
        }

        int n2 = nums1.length;
        int[] ans = new int[n2];

        for (int i = 0; i < n2; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }


    public static void main(String[] args) {

    }

}
