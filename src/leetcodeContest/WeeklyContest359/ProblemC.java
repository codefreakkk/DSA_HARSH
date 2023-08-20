package leetcodeContest.WeeklyContest359;
import java.util.*;

public class ProblemC {

    static class Comp implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(0) - o2.get(0);
        }
    }

    private static int findNextIndex(int index, int end, List<List<Integer>> offers) {
        int low = index, high = offers.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int start = offers.get(mid).get(0);
            if (start > end) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    private static int solve(int index, int n, List<List<Integer>> offers, int[] dp) {
        if (index == n) return 0;
        if (dp[index] != -1) {
            return dp[index];
        }

        int notSell = solve(index + 1, n, offers, dp);

        int nextIndex = findNextIndex(index + 1, offers.get(index).get(1), offers);
        int sell = offers.get(index).get(2);
        if (nextIndex != -1) {
            sell += solve(nextIndex, n, offers, dp);
        }
        return dp[index] = Math.max(sell, notSell);
    }

    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, new Comp());

        int[] dp = new int[offers.size() + 1];
        Arrays.fill(dp, -1);

        return solve(0, offers.size(), offers, dp);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(0, 0, 1));
        list.add(List.of(0,2,10));
        list.add(List.of(1,3,2));
        System.out.println(maximizeTheProfit(5, list));
    }
}
