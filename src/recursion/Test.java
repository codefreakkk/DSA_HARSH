package recursion;

import java.sql.Array;
import java.util.*;



public class Test {
    public static String reverse(String s) {
        StringBuilder string = new StringBuilder(s);
        return string.reverse().toString();
    }

    public static String reverseWords(String s) {
        int size = s.length();
        int i = 0, j = 0;
        String ans = "";

        while (j <= size) {
            if (j == size - 1) {
                ans += reverse(s.substring(i, j + 1));
                break;
            }

            if (s.charAt(j) == ' ') {
                ans += reverse(s.substring(i, j)) + " ";
                i = j;
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "God Ding";
        System.out.println(reverseWords(s));
    }
}

