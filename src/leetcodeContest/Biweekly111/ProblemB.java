package leetcodeContest.Biweekly111;
import java.util.*;
public class ProblemB {

    public static boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n = str1.length(), m = str2.length();

        while (i != n && j != m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }
            else if (str1.charAt(i) == 'z' && str2.charAt(j) == 'a') {
                i++;
                j++;
            }
            else if (str1.charAt(i) + 1 == str2.charAt(j)) {
                i++;
                j++;
            }
            else i++;
        }
        return j >= m;
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "ad";
        System.out.println(canMakeSubsequence(s1, s2));
    }
}
