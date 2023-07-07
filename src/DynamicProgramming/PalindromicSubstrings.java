package DynamicProgramming;

public class PalindromicSubstrings {

    private int expand(int i, int j, String s) {
        int count = 0;
        while (s.charAt(i) == s.charAt(j)) {
            count++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int n = s.length();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (n % 2 == 0) {
                ans += expand(i, i + 1, s);
            }
            else {
                ans += expand(i, i, s);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
