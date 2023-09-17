package leetcodeContest.WeeklyContest363;
import java.util.*;


// not solved
public class ProblemB {

    public static int countWays(List<Integer> nums) {
        int n = nums.size();
        Collections.sort(nums);

        int num = nums.get(0);
        boolean same = false;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) != num) {
                same = true;
                break;
            }
        }

        if (same) {
            if (num < n) {
                return 2;
            }
            else return 1;
        }

        int count = 0, max = num;
        for (int it : nums) {
            max = Math.max(max, it);
        }
        if (max < n) count++;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == 0) {
                count++;
            }
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(6,0,3,3,6,7,2,7);
        System.out.println(countWays(list));
    }
}
