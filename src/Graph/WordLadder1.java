package Graph;

import java.util.*;

public class WordLadder1 {
    class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int wordLadder1(String startWord, String targetWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        for (String str : wordList)
            set.add(str);

        set.remove(startWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startWord, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;

            if (word.equals(targetWord))
                return level;

            // do transformation
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    String ans = word.substring(0, i) + ((char) (j + 'a')) + word.substring(i + 1, word.length());
                    if (set.contains(ans)) {
                        set.remove(ans);
                        queue.offer(new Pair(ans, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder1 o = new WordLadder1();
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord = "dfs";
        System.out.println(o.wordLadder1(startWord, targetWord, wordList));
    }
}
