package DynamicProgramming;
import java.util.*;

public class WordBreak {

    // memoization code
    private boolean solve(int index, int n, String s, Set<String> set, int[] dp) {
        if (index >= n) return true;

        if (dp[index] != -1) {
            return dp[index] == 0 ? false : true;
        }

        for (int i = index; i < n; i++) {
            if (set.contains(s.substring(index, i + 1)) && solve(i + 1, n, s, set, dp)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }

    // tabulation code
    public boolean tabulation(String s, Set<String> set) {
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int index = n; index >= 0; index--) {
            for (int i = index; i < n; i++) {
                if (set.contains(s.substring(index, i + 1)) && dp[i + 1] == 1) {
                    dp[index] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1 ? true : false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> set = new HashSet<>();
        for (String str : wordDict) set.add(str);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return tabulation(s, set);
    }

    public static void main(String[] args) {
        WordBreak o = new WordBreak();
        String s = "catsandog";
        List<String> list = List.of("cats","dog","sand","and","cat");
        System.out.println(o.wordBreak(s, list));
    }
}
