package CODES;
import java.util.*;

public class TestB {

    public static String generateString(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int length = l1 + l2 - 1;

        // append 'A' to string of length
        char[] ch = new char[length];
        for (int i = 0; i < length; i++) {
            ch[i] = 'A';
        }

        // store the index of 'T' (True) in list
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < l2; i++) {
            if (s2.charAt(i) == 'T') {
                indexes.add(i);
            }
        }
        Collections.sort(indexes);
        System.out.println(indexes);

        int lastIndex = -1;
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            if (index + l1 - 1 > length || index < lastIndex) {
                return "-1";
            }

            // override characters in ch[] starting from index
            int j = index, k = 0;
            while(k < l1) {
                ch[j++] = s1.charAt(k++);
            }
            lastIndex = j;
        }

        String ans = "";
        for (char it : ch) {
            ans += it;
        }
        for (int i = 0; i < length; i++) {
            if (ans.charAt(i) != 'A') {
                return ans;
            }
        }

        ch[length - 3] = 'B';
        ans = "";
        for (char it : ch) {
            ans += it;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "ZXC", s2 = "TFF";
        System.out.println(generateString(s1, s2));
    }
}