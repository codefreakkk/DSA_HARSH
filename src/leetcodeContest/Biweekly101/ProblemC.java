package leetcodeContest.Biweekly101;
import java.util.*;

public class ProblemC {

    public long makeSumEqual(int[] nums, int k) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            int next = (i + k) % n;

            while (next != i) {
                visited[next] = true;
                list.add(nums[next]);
                next= (next + k) % n;
            }

            // find median
            Collections.sort(list);
            int median = list.get(list.size() / 2);

            // find difference
            for (Integer integer : list) {
                total += Math.abs(median - integer);
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
