package contests.leetcode.Biweekly95;

import java.util.*;

public class ProblemB {
    List<Integer> list;
    int pointer = 0, k;
    public ProblemB(int value, int k) {
        this.k = k;
        this.list = new ArrayList<>();
        list.add(value);
    }

    public boolean consec(int num) {
        if (list.size() < k) {
            list.add(num);
            return false;
        }
        list.add(num);
        pointer++;

        for (int i = pointer; i < list.size(); i++) {
            if (list.get(i) != list.get(0))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ProblemB o = new ProblemB(1, 2);
        System.out.println(o.consec(1));
        System.out.println(o.consec(2));
        System.out.println(o.consec(1));
        System.out.println(o.consec(1));
        System.out.println(o.consec(1));
    }
}
