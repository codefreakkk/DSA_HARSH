package leetcodeContest.Biweekly106;

public class ProblemB {

    private static boolean check(String s) {
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count <= 1;
    }

    public static int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0, ans = 0;

        while (j < n) {
            if (check(s.substring(i, j + 1)) == true) {
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            else i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(longestSemiRepetitiveSubstring(s));
    }
}
