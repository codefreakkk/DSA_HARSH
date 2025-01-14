package REVISION.recursion_2;

import java.util.*;

public class LetterCombinationOfAPhone {

    private void init(Map<Character, String> map) {
        // add phone number values in map
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private void solve(int index, String processed, String digit, Map<Character, String> map, List<String> ans) {
        if (index == digit.length()) {
            ans.add(processed);
            return;
        }

        char ch = digit.charAt(index);
        for (int i = 0; i < map.get(ch).length(); i++) {
            solve(index + 1, processed + map.get(ch).charAt(i), digit, map, ans);
        }

    }

    public List<String> letterCombination(String digits) {
        Map<Character, String> map = new HashMap<>();
        init(map);

        List<String> ans = new ArrayList<>();
        solve(0, "", digits, map, ans);
        return ans;
    }



}
