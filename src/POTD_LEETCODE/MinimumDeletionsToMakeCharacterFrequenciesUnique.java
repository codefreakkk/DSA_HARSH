package POTD_LEETCODE;
import java.util.*;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (char ch : s.toCharArray()) {
            int key = ch - 'a';
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> mp : map1.entrySet()) {
            int frequency = mp.getValue();
            if (map2.containsKey(frequency)) {
                while (frequency > 0 && map2.containsKey(frequency)) {
                    ans++;
                    frequency--;
                }
            }
            map2.put(frequency, 1);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
