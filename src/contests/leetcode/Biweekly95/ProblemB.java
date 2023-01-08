package contests.leetcode.Biweekly95;

import java.util.*;

public class ProblemB {

    int value, length, k;
    public ProblemB(int value, int k) {
        this.value = value;
        this.length = 0;
        this.k = k;
    }

    public boolean consec(int num) {
        if (value == num)
            length++;
        else
            length = 0;

        if (length < k)
            return false;

        return true;
    }

    public static void main(String[] args) {
        ProblemB o = new ProblemB(4, 3);
        System.out.println(o.consec(4));
        System.out.println(o.consec(4));
        System.out.println(o.consec(4));
        System.out.println(o.consec(3));
    }
}
