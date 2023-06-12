package leetcodeContest.Biweekly106;
import java.util.*;

public class ProblemC {

    public static int sumDistances(int[] nums, String s, int d) {
        int mod = (int) 1e9+7;
        int n = s.length();
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'R') {
                nums[i] += d;
            }
            else {
                nums[i] -= d;
            }
        }
        Arrays.sort(nums);
        long sum = 0;
        long prefixsum = 0;

        for(int i = 0 ; i < n ;i++){
            sum = (sum + i*(long)nums[i] - prefixsum)%mod;
            prefixsum += nums[i]%mod;
        }

        return (int)sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        String s = "RL";
        int d = 2;
        System.out.println(sumDistances(nums, s, d));
    }
}
