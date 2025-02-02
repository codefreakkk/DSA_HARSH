package leetcodeContest.Biweekly149;

import java.util.*;
import java.util.TreeMap;

public class ProblemA {
    public static String findValidPair(String s) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        List<Integer> a = new ArrayList<>();
        a.removeAll(a);

        String ans = "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            if (map.containsKey(ch) && map.get(ch) == ch) {
                ans += ch;
                map.remove(ch);
                count++;
            }
            if (count == 2) return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
