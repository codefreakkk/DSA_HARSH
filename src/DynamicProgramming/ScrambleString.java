package DynamicProgramming;
import java.util.*;

public class ScrambleString {

    // memoization
    private boolean solve(String s1, String s2, HashMap<String, Boolean> dp) {
        int n = s1.length();
        if (s1.equals(s2)) return true;
        if (n == 1) return false;

        String key = s1 + " " + s2;
        if (dp.containsKey(key)) return dp.get(key);

        for (int i = 1; i < n; i++) {
            if (solve(s1.substring(0, i), s2.substring(0, i), dp) && solve(s1.substring(i), s2.substring(i), dp)) {
                dp.put(key, true);
                return true;
            }
            if (solve(s1.substring(0, i), s2.substring(n - i), dp) && solve(s1.substring(i), s2.substring(0, n - i), dp)) {
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }

    // memoization
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> dp = new HashMap<>();
        return solve(s1, s2, dp);
    }

    public static void main(String[] args) {

    }
}
