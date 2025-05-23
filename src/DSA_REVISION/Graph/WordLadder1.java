package DSA_REVISION.Graph;

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

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>();
        for (String word : wordList) {
            wordsSet.add(word);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;

            if (word.equals(endWord)) {
                return level;
            }

            // hit
            for (int i = 0; i < word.length(); i++) {
                StringBuilder tempWord = new StringBuilder(word);
                for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                    tempWord.setCharAt(i, alphabet);
                    String newWord = tempWord.toString();

                    if (wordsSet.contains(newWord)) {
                        queue.offer(new Pair(newWord, level + 1));
                        wordsSet.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
