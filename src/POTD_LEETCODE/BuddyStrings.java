package POTD_LEETCODE;

import java.util.*;

public class BuddyStrings {


    private String swap(int index1, int index2, String s) {
        char[] ch = s.toCharArray();
        char temp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = temp;


        String ans = "";
        for (char it : ch) ans += it;
        return ans;
    }

    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) return false;

        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char ch : s.toCharArray()) set.add(ch);
            return set.size() < s.length();
        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                list.add(i);
            }
        }

        if (list.size() != 2) return false;
        String str = swap(list.get(0), list.get(1), s);
        return str.equals(goal);
    }



    public static void main(String[] args) {
        BuddyStrings o = new BuddyStrings();

        String s = "ab", goal = "ba";
        System.out.println(o.buddyStrings(s, goal));
    }
}
