package Graph;

import java.util.*;

public class WordLadder2Optimized {
    public void dfs(String word, String startWord, List<String> sequence, HashMap<String, Integer> map, List<List<String>> ans) {
        if (word.equals(startWord)) {
            List<String> list = new ArrayList<>(sequence);
            Collections.reverse(list);
            ans.add(list);
            return;
        }
        int length = word.length();
        int steps = map.get(word);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 26; j++) {
                String transformed = word.substring(0, i) +
                        ((char) (j + 'a')) + word.substring(i + 1, length);
                if (map.containsKey(transformed) && (map.get(transformed) + 1) == steps) {
                    sequence.add(transformed);
                    dfs(transformed, startWord, sequence, map, ans);
                    sequence.remove(sequence.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (String str : wordList)
            set.add(str);

        set.remove(startWord);
        map.put(startWord, 1);
        queue.offer(startWord);

        // find minimum steps and store in map with <String, Integer>
        int length = startWord.length();
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int steps = map.get(word);

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 26; j++) {
                    String transformed = word.substring(0, i) + ((char) (j + 'a')) + word.substring(i + 1, length);
                    if (set.contains(transformed)) {
                        queue.offer(transformed);
                        set.remove(transformed);
                        map.put(transformed, steps + 1);
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> sequence = new ArrayList<>();

        // backtrack from targetWord to startWord to get ans use formed HASH_MAP
        if (map.containsKey(targetWord)) {
            sequence.add(targetWord);
            dfs(targetWord, startWord, sequence, map, ans);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
