package leetcodeContest.WeeklyContest363;
import java.util.*;
public class ProblemB {

    public static int countWays(List<Integer> nums) {
        int n = nums.size();
        Collections.sort(nums);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 > nums.get(i) && i + 1 < nums.get(i + 1)) {
                ans++;
            }
        }
        if (nums.get(0) != 0) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(6,0,3,3,6,7,2,7);
        System.out.println(countWays(list));
    }
}
