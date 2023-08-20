package leetcodeContest.WeeklyContest359;
import java.util.*;

public class ProblemC {

    static class Comp implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if (o1.get(0) == o2.get(0)) {
                return o2.get(2) - o1.get(2);
            }
            return o1.get(0) - o2.get(0);
        }
    }

    public static int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, new Comp());

        int ans = 0, size = offers.size();
        for (int i = 0; i < size; i++) {
            int max = offers.get(i).get(2);
            int previous = offers.get(i).get(1);

            for (int j = i + 1; j < size; j++) {
                if (offers.get(j).get(0) == offers.get(j - 1).get(0)) {
                    continue;
                }
                if (offers.get(j).get(0) > previous) {
                    max += offers.get(j).get(2);
                }
            }
            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(0, 0, 1));
        list.add(List.of(0,2,10));
        list.add(List.of(1,3,2));
        System.out.println(maximizeTheProfit(5, list));
    }
}
