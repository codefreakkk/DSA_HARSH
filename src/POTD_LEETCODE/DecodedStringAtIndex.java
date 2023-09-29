package POTD_LEETCODE;

public class DecodedStringAtIndex {

    public static String decodeString(String s, int k) {
        long length = 0;
        int index = 0;

        while (length < k) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                length *= ch - '0';
            }
            else {
                length++;
            }
            index++;
        }

        for (int i = index - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                length /= ch - '0';
                k %= length;
            }
            else {
                if (k == 0 || k == length) {
                    return ch + "";
                }
                length--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "ha22";
        int k = 5;
        System.out.println(decodeString(s, k));
    }
}
