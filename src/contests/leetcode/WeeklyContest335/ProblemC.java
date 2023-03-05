package contests.leetcode.WeeklyContest335;
import java.util.*;
public class ProblemC {
    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static int findValidSplit(int[] nums) {
        List<Long> prefix = new ArrayList<>();
        prefix.add((long)nums[0]);
        for (int i = 1; i < nums.length - 1; i++) {
            long product = prefix.get(i - 1) * nums[i];
            prefix.add(product);
        }

        List<Long> suffix = new ArrayList<>();
        suffix.add((long)nums[nums.length - 1]);
        for (int i = nums.length - 2; i > 0; i--) {
            long product = suffix.get(suffix.size() - 1) * nums[i];
            suffix.add(product);
        }
        Collections.reverse(suffix);

        for (int i = 0; i < prefix.size(); i++) {
            if (gcd(prefix.get(i), suffix.get(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,3, 2 , 4 ,1};
        System.out.println(findValidSplit(nums));
    }
}
