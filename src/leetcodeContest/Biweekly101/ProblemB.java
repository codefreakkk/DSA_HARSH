package leetcodeContest.Biweekly101;
import java.util.*;
public class ProblemB {

    public static int maxCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chArray = chars.toCharArray();

        for (int i = 0; i < chArray.length; i++) {
            map.put(chArray[i], i);
        }

        int current = 0, ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                current += vals[map.get(ch)];
            }
            else current += (ch - 'a') + 1;

            ans = Math.max(ans, current);
            if (current < 0) current = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        String chars = "abc";
        int[] vals = {-1, -1, -1};
        System.out.println(maxCostSubstring(s, chars, vals));
    }
}
