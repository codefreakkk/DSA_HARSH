package DynamicProgramming;

import java.util.Arrays;

public class      LongestStringChain {

    private boolean isPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        int i = 0, j = 0;

        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else i++;
        }
        return i == s1.length() && j == s2.length();
    }

    public int longestStringChain(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });

        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int index = 1; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (1 + dp[prev] > dp[index] && isPossible(words[index], words[prev])) {
                    dp[index] = 1 + dp[prev];
                }
            }
            max = Math.max(dp[index], max);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestStringChain o = new LongestStringChain();
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(o.longestStringChain(words));
    }
}
