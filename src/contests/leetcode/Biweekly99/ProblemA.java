package contests.leetcode.Biweekly99;
import java.util.*;
public class ProblemA {
    public static int splitNum(int num) {
        String string = String.valueOf(num);
        char[] ch = string.toCharArray();
        Arrays.sort(ch);

        String num1 = "";
        for (int i = 0; i < ch.length; i += 2)
            num1 += ch[i];

        String num2 = "";
        for (int i = 1; i < ch.length; i += 2)
            num2 += ch[i];

        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

    public static void main(String[] args) {
        int num = 4325;
        ProblemA o = new ProblemA();
        System.out.println(o.splitNum(num));
    }
}
