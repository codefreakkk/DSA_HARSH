package JUST_CODES;

public class NVDIA_PROBLEM_B {
    public static boolean binaryToDecimal(String str) {
        int power = str.length() - 1;
        char[] ch = str.toCharArray();
        int ans = 0;

        for (int i = 0; i < ch.length; i++) {
            int num = ch[i] - '0';
            ans += Math.pow(2, power--) * num;
        }

        if ((ans & ans - 1) == 0)
            return true;

        return false;
    }
    public static void main(String[] args) {
        String str = "1000";
        boolean ans = binaryToDecimal(str);
        System.out.println(ans);
    }
}
