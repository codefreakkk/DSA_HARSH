package contests.leetcode.Biweekly99;
import java.util.*;
public class ProblemC {
    public static int countWays(int[][] ranges) {
        int last = -1, result = 1, mod = (int) 1e9+7;
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);

        for (int[] r : ranges) {
            if (last < r[0])
                result = result * 2 % mod;

            last = Math.max(last, r[1]);
        }
        return result;
    }
    public static void main(String[] args) {
    }
}
