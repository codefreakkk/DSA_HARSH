package DynamicProgramming;
import java.util.*;

public class WordBreakII {

    private void solve(int index, String output, String s, Set<String> set, List<String> ans) {
        if (index >= s.length()) {
            ans.add(output.trim());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1))) {
                solve(i + 1, output + s.substring(index, i + 1) + " ", s, set, ans);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String it : wordDict) set.add(it);

        List<String> ans = new ArrayList<>();
        solve(0, "", s, set, ans);
        return ans;
    }

    public static void main(String[] args) {
        WordBreakII o = new WordBreakII();
        String s = "catsanddog";
        List<String> wordDict = List.of("cat","cats","and","sand","dog");
        System.out.println(o.wordBreak(s, wordDict));
    }
}
