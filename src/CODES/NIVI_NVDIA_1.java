package CODES;
import javax.imageio.stream.ImageInputStream;
import java.util.*;

public class NIVI_NVDIA_1 {

    private static boolean checkAnagram(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str1.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    public static String sortString(String str, HashMap<String, String> map) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String sortedString = String.valueOf(arr);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String current = entry.getKey();
            boolean isAnagram = checkAnagram(sortedString, current);
            if (isAnagram) {
                map.remove(current);
                return sortedString;
            }

        }
        return sortedString;
    }

    public static int groupAnagrams(List<String> str) {
        if (str.size() == 0) {
            return 0;
        }
        HashMap<String, String> map = new HashMap<>();

        for (String s : str) {
            String temp = s;
            String sortedString = sortString(s, map);
            map.put(sortedString, temp);
        }
        System.out.println(map);

        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int ans = groupAnagrams(List.of("cat", "dog", "tac", "god"));
        System.out.println(ans);
    }
}
