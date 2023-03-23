package leetcodeContest.WeeklyContest335;
import java.util.*;

public class ProblemC {
    private static int N = (int) 1e6 + 1;
    private static List<Integer> primeFactors(int num) {
        int[] sieve = new int[N];
        for (int i = 0; i < N; i++)
            sieve[i] = i;

        for (int i = 2; i * i < N; i++) {
            if (sieve[i] != i) continue;
            for (int j = i * i; j < N; j += i)
                sieve[j] = i;
        }

        List<Integer> result = new ArrayList<>();
        while (num != 1) {
            int div = sieve[num];
            while (num % div == 0) num /= div;
            result.add(div);
        }
        return result;
    }

    public static int findValidSplit(int[] nums) {
        int n = nums.length;
        int[] lastFactIndex = new int[N];

        for (int i = 0; i < n; i++) {
            List<Integer> fact = primeFactors(nums[i]);
            for (int f : fact) {
                lastFactIndex[f] = i;
            }
        }

        int resultIndex = 0, it = 0;
        while (it <= resultIndex) {
            List<Integer> fact = primeFactors(nums[it]);
            for (int f : fact)
                resultIndex = Math.max(resultIndex, lastFactIndex[f]);

            it++;
        }
        if (it == n) return -1;
        return it - 1;
    }

    public static void main(String[] args) {
        int[] nums = {4,3, 2 , 4 ,1};
        System.out.println(findValidSplit(nums));
    }
}
