package leetcodeContest.WeeklyContest360;
import java.util.*;

public class ProblemB {

    public static long minimumPossibleSum(int n, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(target - i)) {
                n++;
            }
            else {
                ans += i;
                map.put(i, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1, target = 1;
        System.out.println(minimumPossibleSum(n, target));
    }
}
