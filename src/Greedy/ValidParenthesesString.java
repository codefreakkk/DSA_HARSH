package Greedy;

public class ValidParenthesesString {
    public static boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;

        for (char i : s.toCharArray()) {
            if (i == '(') {
                cmin++;
                cmax++;
            }
            else if (i == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            }
            else {
                cmin = Math.max(cmin - 1, 0);
                cmax++;
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }

    public static void main(String[] args) {
        String s = "(*)(";
        System.out.println(checkValidString(s));
    }
}
