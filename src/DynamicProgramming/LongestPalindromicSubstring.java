package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        int l = 0, r = 0, maxLength = 1;
        int start = 0, end = 0;

        // odd length
        for (int i = 0; i < n; i++) {
            l = i;
            r = i;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                else break;
            }
            int length = r - l - 1;
            if (length > maxLength) {
                maxLength = length;
                start = l + 1;
                end = r - 1;
            }
        }

        // even length
        for (int i = 0; i < n; i++) {
            l = i;
            r = i + 1;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                }
                else break;
            }
            int length = r - l - 1;
            if (length > maxLength) {
                maxLength = length;
                start = l + 1;
                end = r - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
