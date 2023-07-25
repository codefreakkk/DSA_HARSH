package DynamicProgramming;
import java.util.*;

public class RussianDollEnvelops {

    private int upperBound(int target, List<Integer> dp) {
        int low = 0, high = dp.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (dp.get(mid) == target) {
                return mid;
            }
            if (dp.get(mid) < target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }

    public int maxEnvelops(int[][] envelops) {
        Arrays.sort(envelops, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<Integer> dp = new ArrayList<>();
        dp.add(envelops[0][1]);

        for (int i = 1; i < envelops.length; i++) {
            if (envelops[i][1] > dp.get(dp.size() - 1)) {
                dp.add(envelops[i][1]);
            }
            else {
                int index = upperBound(envelops[i][1], dp);
                dp.set(index, envelops[i][1]);
            }
        }
        return dp.size();
    }

    public static void main(String[] args) {

    }
}
