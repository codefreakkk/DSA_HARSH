package REVISION.recursion_2;

import java.util.*;

public class MaximumLengthOfConcatenatedString {
    private boolean isUnique(String value, int[] visited) {
        for (char ch : value.toCharArray()) {
            if (visited[ch - 'a'] == 1) {
                return false;
            }
        }
        return true;
    }

    public int solve(int index, int length, int[] visited, List<String> arr) {
        if (index >= arr.size()) {
            return length;
        }

        if (isUnique(arr.get(index), visited)) {
            for (char ch : arr.get(index).toCharArray()) {
                visited[ch - 'a'] = 1;
            }
            int left = solve(index + 1, length + arr.get(index).length(), visited, arr);

            // backtrack
            for (char ch : arr.get(index).toCharArray()) {
                visited[ch - 'a'] = 0;
            }
            int right = solve(index + 1, length, visited, arr);
            return Math.max(left, right);
        } else {
            return solve(index + 1, length, visited, arr);
        }
    }

    public int maxLength(List<String> arr) {
        int[] visited = new int[26];
        return solve(0, 0, visited, arr);
    }


}
