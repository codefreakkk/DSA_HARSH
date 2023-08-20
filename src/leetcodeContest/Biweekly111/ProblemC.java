package leetcodeContest.Biweekly111;
import java.util.*;

public class ProblemC {

    private int getLISCount(List<Integer> nums) {
        return 1;
    }

    public int minimumOperation(List<Integer> nums) {
        int n = nums.size();
        int lisCount = getLISCount(nums);
        return n - lisCount;
    }

    public static void main(String[] args) {
        ProblemC o = new ProblemC();
        List<Integer> nums = List.of(2, 2, 1, 1, 2);
        System.out.println(o.minimumOperation(nums));
    }
}
