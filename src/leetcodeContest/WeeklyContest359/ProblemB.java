package leetcodeContest.WeeklyContest359;

import java.util.*;
public class ProblemB {

    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i = 1; set.size() < n; i++) {
            if (!set.contains(k - i)) {
                ans += i;
                set.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ProblemB o = new ProblemB();
        System.out.println(o.minimumSum(2, 6));
    }
}
