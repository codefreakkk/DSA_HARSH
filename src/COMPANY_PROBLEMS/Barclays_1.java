package COMPANY_PROBLEMS;
import java.util.*;

public class Barclays_1 {

    public static String generateString(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int length = l1 + l2 - 1;

        char[] ch = new char[length];
        for (int i = 0; i < length; i++) {
            ch[i] = 'A';
        }

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < l2; i++) {
            if (s2.charAt(i) == 'T') {
                indexes.add(i);
            }
        }
        Collections.sort(indexes);

        int lastIndex = -1;
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            if (index + l1 - 1 > length || index < lastIndex) {
                return "-1";
            }

            int j = 0, k = 0;
            for (j = index; j < l1; j++) {
                ch[j] = s1.charAt(k++);
            }
            lastIndex = j - 1;
        }

        String ans = "";
        for (char it : ch) {
            ans += it;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "AAAA", s2 = "FTFF";
        System.out.println(generateString(s1, s2));
    }
}
