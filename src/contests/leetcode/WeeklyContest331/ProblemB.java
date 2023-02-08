package contests.leetcode.WeeklyContest331;
import java.util.*;

public class ProblemB {
    public boolean isVowel(char val) {
        return val == 'a' || val == 'e' || val == 'o' || val == 'u' || val == 'i';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Integer> prefix = new ArrayList<>();
        prefix.add(0);

        for (String word : words) {
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                prefix.add(prefix.get(prefix.size() - 1) + 1);
            }
            else prefix.add(prefix.get(prefix.size() - 1));
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int value = prefix.get((queries[i][1] + 1)) - prefix.get(queries[i][0]);
            ans[i] = value;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"aba","bcb","ece","aa","e"};
        int[][] queries = {
                {0, 2},{1, 4},{1, 1}
        };
//        System.out.println(Arrays.toString(vowelStrings(s, queries)));
    }
}
