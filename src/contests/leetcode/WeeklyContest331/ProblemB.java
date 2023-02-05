package contests.leetcode.WeeklyContest331;
import java.util.*;
public class ProblemB {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        List<Integer> list = new ArrayList<>();

        for (int[] num : queries) {
            long count = 0;
            for (int i = num[0]; i <= num[1]; i++) {
                char first = words[i].charAt(0);
                char last = words[i].charAt(words[i].length() - 1);
                if (set.contains(first) && set.contains(last)) {
                    count++;
                }
            }
            list.add((int)count);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"a", "e", "e", "e","e"};
        int[][] queries = {
                {0,0},{1, 4},{1,1}
        };
        System.out.println(Arrays.toString(vowelStrings(s, queries)));
    }
}
