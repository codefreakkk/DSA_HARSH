package JUST_CODES;

import java.util.*;

public class RestoreIPAddress {
    public static boolean isValid(String current) {
        if (current.length() > 3 || current.length() == 0)
            return false;

        if (current.length() > 1 && current.charAt(0) == '0')
            return false;

        if (Integer.parseInt(current) > 255)
            return false;

        return true;
    }
    public static void solve(String str, int dots, int index, List<String> output, List<String> ans) {
        if (dots == 3) {
            String current = str.substring(index, str.length());
            if (isValid(current)) {
                String temp = "";
                for (String s : output)
                    temp += s + ".";

                temp += current;
                ans.add(temp);
                return;
            }
        }

        for (int i = index; i < Math.min(i + 3, str.length()); i++) {
            String element = str.substring(index, i + 1);
            if (isValid(element)) {
                output.add(element);
                solve(str, dots + 1, i + 1, output, ans);
                output.remove(output.size() - 1);
            }
        }
    }

    public static List<String> restoreIpAddress(String str) {
        List<String> ans = new ArrayList<>();
        List<String> output = new ArrayList<>();
        solve(str, 0, 0, output, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "101023";
        List<String> ans = restoreIpAddress(s);
        System.out.println(ans);
    }
}
