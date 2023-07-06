package DynamicProgramming;
import java.util.*;

public class WordBreak {

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

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> set = new HashSet<>();
        for (String str : wordDict) set.add(str);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, n, s, set, dp);
    }

    public static void main(String[] args) {
        WordBreak o = new WordBreak();
        String s = "catsandog";
        List<String> list = List.of("cats","dog","sand","and","cat");
        System.out.println(o.wordBreak(s, list));
    }
}
