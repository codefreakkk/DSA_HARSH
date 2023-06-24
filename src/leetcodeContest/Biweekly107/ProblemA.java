package leetcodeContest.Biweekly107;
import java.util.*;

public class ProblemA {

    private static String reverseWord(String word) {
        StringBuilder string = new StringBuilder(word);
        return string.reverse().toString();
    }

    public static int maximumNumberOfStringPair(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String it : words) map.put(it, map.getOrDefault(it, 0) + 1);

        int ans = 0;
        for (String word : words) {
            String reverse = reverseWord(word);

            if (word.equals(reverse) && map.get(word) == 1) {
                continue;
            }

            if (map.containsKey(reverse)) {
                ans++;
                map.remove(word);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"aa","ab"};
        System.out.println(maximumNumberOfStringPair(words));
    }
}
