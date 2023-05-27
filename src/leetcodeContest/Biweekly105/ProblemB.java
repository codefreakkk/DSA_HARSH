package leetcodeContest.Biweekly105;

import java.util.*;

public class ProblemB {

    private static int solve(String s, String[] dict, Set<String> set, int index, int[] dp) {
        if (index >= s.length()) return 0;
        if (dp[index] != -1) return dp[index];

        String current = "";
        int min = s.length() + 1;
        for (int i = index; i < s.length(); i++) {
            current += s.charAt(i);

            int extra = (set.contains(current)) ? 0 : current.length();
            int nextExtra = solve(s, dict, set, i + 1, dp);
            int totalExtra = extra + nextExtra;

            min = Math.min(min, totalExtra);
        }
        return dp[index] = min;
    }

    public static int minExtraCharacter(String s, String[] dict) {
        Set<String> set = new HashSet<>();
        for (String str : dict) set.add(str);

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(s, dict, set, 0, dp);
    }

    public static void main(String[] args) {
        String s = "smsvy";
        String[] dict = {"j","p","y","r","t","nj","k","xj","vg","da","m","u","yq","as","wh","b","vo","h","wb","z","np","uy","i","f","w","wg","s","ls","xf","ou","mj","pf"};
        System.out.println(minExtraCharacter(s, dict));
    }
}
