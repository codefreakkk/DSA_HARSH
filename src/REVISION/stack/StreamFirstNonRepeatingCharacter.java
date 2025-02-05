package REVISION.stack;
import java.util.*;

public class StreamFirstNonRepeatingCharacter {

    public String firstNonRepeatingCharacter(String s) {
        int n = s.length();

        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        String ans = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
            queue.offer(ch);

            while (!queue.isEmpty()) {
                if (map.get(queue.peek()) > 1) {
                    queue.poll();
                } else {
                    ans += queue.peek();
                    break;
                }
            }
            if (queue.isEmpty()) {
                ans += '#';
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
