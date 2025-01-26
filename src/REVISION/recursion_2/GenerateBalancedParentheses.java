package REVISION.recursion_2;
import java.util.*;

public class GenerateBalancedParentheses {

    private void solve(int open, int close, String output, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(output);
            return;
        }
        if (open != 0) {
            solve(open - 1, close, output + "(", ans);
        }
        if (close > open) {
            solve(open, close - 1, output + ")", ans);
        }
    }

    public List<String> generateBalancedParentheses(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, n, "", ans);
        return ans;
    }


    public static void main(String[] args) {

    }
}
