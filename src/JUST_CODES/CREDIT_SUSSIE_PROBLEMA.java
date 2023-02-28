package JUST_CODES;

import java.util.*;

public class CREDIT_SUSSIE_PROBLEMA {
    private int sum = 0;
    private void solve(List<Integer> list) {
        if (list.size() == 1)
            return;

        boolean flag = true;
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (flag == true) {
                sum += list.get(i);
            }
            else {
                temp.add(list.get(i));
            }
            flag = !flag;
        }
        solve(temp);
    }
    public int findTarget(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);

        solve(list);
        return sum;
    }

    public int findTargetWithoutRecursion(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);

        int sum = 0;
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i += 2)
                sum += i;

            for (int i = 0; i < list.size(); i += 2)
                list.remove(i);
        }
        return sum;
    }
    public static void main(String[] args) {
        CREDIT_SUSSIE_PROBLEMA o = new CREDIT_SUSSIE_PROBLEMA();
        int n = 7;
        System.out.println(o.findTarget(n));
    }
}
