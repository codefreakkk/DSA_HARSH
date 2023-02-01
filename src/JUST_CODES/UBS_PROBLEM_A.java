package JUST_CODES;

import java.util.HashMap;

public class UBS_PROBLEM_A {
    public static String getMaxXor(String s, String t) {
        int size = t.length();

        HashMap<Character, Integer> map = new HashMap<>();
        char[] temp = t.toCharArray();

        map.put('1', 0);
        map.put('0', 0);

        for (char val : temp)
            map.put(val, map.getOrDefault(val, 0) + 1);

        for (int i = 0; i < size; i++) {
            char element = s.charAt(i);
            if (element == '0') {
                if (map.get('1') > 0) {
                    temp[i] = '1';
                    map.put('1', map.get('1') - 1);
                }
                else temp[i] = '0';
            }
            else {
                if (map.get('0') > 0) {
                    temp[i] = '0';
                    map.put('0', map.get('0') - 1);
                }
                else temp[i] = '1';
            }
        }

        String updated = new String(temp);
        String ans = "";

        for (int i = 0; i < size; i++) {
            int xor = s.charAt(i) - '0' ^ updated.charAt(i) - '0';
            ans += String.valueOf(xor);
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "11001100";
        String t = "11111111";
        System.out.println(getMaxXor(s, t));
    }
}
