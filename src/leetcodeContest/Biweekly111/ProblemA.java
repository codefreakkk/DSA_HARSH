package leetcodeContest.Biweekly111;
import java.util.*;
public class ProblemA {

    public static int countPairs(List<Integer> nums, int target) {
        int count = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(-1,1,2,3,1);
        int target = 2;
        System.out.println(countPairs(nums, target));
    }
}
