package POTD_LEETCODE;

public class MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {
        int count1 = 0, count2 = 0;
        int len1 = word1.length(), len2 = word2.length();
        String merge = "";

        while (count1 < len1 && count2 < len2) {
            if (count1 < len1) {
                merge += word1.charAt(count1++);
            }
            else break;

            if (count2 < len2) {
                merge += word2.charAt(count2++);
            }
            else break;
        }
        if (count1 < len1) merge += word1.substring(count1, len1);
        if (count2 < len2) merge += word2.substring(count2, len2);
        return merge;
    }

    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeAlternately(word1, word2));
    }
}
