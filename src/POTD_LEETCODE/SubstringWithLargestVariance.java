package POTD_LEETCODE;

public class SubstringWithLargestVariance {


    private String reverseString(String s) {
        StringBuilder string = new StringBuilder(s);
        return string.reverse().toString();
    }

    public int largestVariance(String s) {
        int[] frequency = new int[26];
        for (char it : s.toCharArray()) {
            frequency[it - 'a'] = 1;
        }

        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i == j || frequency[i - 'a'] == 0 || frequency[j - 'a'] == 0) {
                    continue;
                }

                String temp = s;
                for (int count = 0; count < 2; count++) {

                    int count1 = 0, count2 = 0;
                    for (char ch : temp.toCharArray()) {
                        if (ch == i) count1++;
                        if (ch == j) count2++;

                        if (count1 < count2) {
                            count1 = count2 = 0;
                        }

                        if (count1 > 0 && count2 > 0) {
                            ans = Math.max(ans, count1 - count2);
                        }
                    }
                    temp = reverseString(temp);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubstringWithLargestVariance o = new SubstringWithLargestVariance();
        String s = "abcde";
        System.out.println(o.largestVariance(s));
    }
}
