package contests.leetcode.WeeklyContest329;

public class ProblemA {
    public static int alternateDigitSum(int n) {
        if (n == 0) return 0;

        String num = String.valueOf(n);
        char[] ch = num.toCharArray();

        int ans = 0;
        boolean flag = true;
        for (int i = 0; i < ch.length; i++) {
            int current = ch[i] - '0';
            if (flag) ans += current;
            else ans -= current;
            flag = !flag;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(886996));
    }
}
