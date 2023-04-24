package JUST_CODES;
import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (String.valueOf(ch).equals("]")) {
                String val = "";
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        break;
                    }
                    val = stack.pop() + val;
                }

                String count = "";
                while (!stack.isEmpty() && stack.peek().charAt(0) - '0' >= 0 && stack.peek().charAt(0) - '0' <= 9) {
                    count = stack.pop() + count;
                }

                String merge = "";
                int num = Integer.parseInt(count);
                while (num > 0) {
                    merge += val;
                    num--;
                }
                stack.push(merge);
            }
            else stack.push(String.valueOf(ch));
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(decodeString(s));
    }
}
;