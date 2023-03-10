package recursion;

import java.util.*;

public class MaxLengthOfConcatedString {
    public static boolean compareString(String firstString, int[] selected) {
        // self check
        int[] visited = new int[26];
        for(int i = 0; i < firstString.length(); i++) {
            if(visited[firstString.charAt(i) - 'a'] == 1) return true;
            visited[firstString.charAt(i) - 'a'] = 1;
        }
        // check for selected
        for(int i = 0; i < firstString.length(); i++) {
            if(selected[firstString.charAt(i) - 'a'] == 1) return true;
        }
        return false;
    }

    public static int solve(int index, int length, List<String> string, int[] selected) {
        if(index >= string.size()) return length;
        String firstString = string.get(index);

        if(compareString(firstString, selected) == true) {
            return solve(index + 1, length, string, selected);
        } else {
            // pick the string
            for(int i = 0; i < firstString.length(); i++) {
                selected[firstString.charAt(i) - 'a'] = 1;
            }
            int leftValue = solve(index + 1, length + firstString.length(), string, selected);

            // skip the string
            for(int i = 0; i < firstString.length(); i++) {
                selected[firstString.charAt(i) - 'a'] = 0;
            }
            int rightValue = solve(index + 1, length, string, selected);
            return Math.max(leftValue, rightValue);
        }
    }

    public static int maxLength(List<String> string) {
        int index = 0;
        int selected[] = new int[26];
        int length = 0;
        return solve(index, length, string, selected);
    }

    public static void main(String[] args) {
        List<String> string = new ArrayList<>();
        string.add("abcdefghijklmnopqrstuvwxyz");
//        string.add("r");
//        string.add("act");
//        string.add("ers");
        System.out.println(maxLength(string));
    }
}