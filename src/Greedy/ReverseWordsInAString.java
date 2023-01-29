package Greedy;

public class ReverseWordsInAString {
    public static String reverseWord(String s) {
        s = s.trim();
        int length = s.length();
        String ans = "";
        int j = length - 1;

        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                ans += s.substring(i + 1, j + 1) + " ";
                j = i;
                while (s.charAt(j) == ' ') j--;
                i = j;
            }
            if (i == 0) ans += s.substring(i, j + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWord(s));
    }
}
