package contests.leetcode.Biweekly97;
import java.util.*;
public class ProblemB {
    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : banned) set.add(num);

        int count = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (sum + i <= maxSum) {
                    count++;
                    sum += i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] banned = {11};
        int n = 7, maxSum = 50;
        System.out.println(maxCount(banned, n, maxSum));
    }
}
