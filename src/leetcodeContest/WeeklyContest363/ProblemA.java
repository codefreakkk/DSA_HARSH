package leetcodeContest.WeeklyContest363;
import java.util.*;

public class ProblemA {

    private int countBits(int num) {
        int count = 0;

        while (num > 0) {
            if ((num & 1) > 0) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    public int sumIndicesWithSetBits(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;

        for (int i = 0; i < n; i++) {
            int bits = countBits(i);
            if (bits == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
