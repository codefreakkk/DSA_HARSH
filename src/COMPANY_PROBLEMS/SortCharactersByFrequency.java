package COMPANY_PROBLEMS;
import java.util.*;

public class SortCharactersByFrequency {

    class Pair {
        char key;
        int value;
        public Pair(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public String frequencyString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char it : s.toCharArray()) {
            map.put(it, map.getOrDefault(it, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (Map.Entry<Character, Integer> it : map.entrySet()) {
            pq.offer(new Pair(it.getKey(), it.getValue()));
        }

        String ans = "";
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int count = pair.value;

            while (count-- > 0) {
                ans += pair.key;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SortCharactersByFrequency o = new SortCharactersByFrequency();
        String s = "tree";
        System.out.println(o.frequencyString(s));
    }
}
