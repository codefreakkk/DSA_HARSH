package Strings;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] str) {
        int size = str.length;
        int count = str[0].length();
        String first = str[0];

        for (int i = 1; i < size; i++) {
            int j = 0;
            while (j < first.length() && j < str[i].length() && str[i].charAt(j) == first.charAt(j))
                j++;

            // take minimum count because of common prefix amongst all input strings
            count = Math.min(count, j - 1);
        }
        return first.substring(0, count + 1);
    }

    public static void main(String[] args) {
        String[] str = {"dog","dogg","dof"};
        System.out.println(longestCommonPrefix(str));
    }
}
