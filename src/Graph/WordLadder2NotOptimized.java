package Graph;

import java.util.*;

public class WordLadder2NotOptimized {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        for (String str : wordList)
            set.add(str);

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> initial = new ArrayList<>();
        initial.add(startWord);
        queue.offer(initial);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        while (!queue.isEmpty()) {
            ArrayList<String> current = queue.poll();
            String word = current.get(current.size() - 1);

            if (current.size() > level) {
                level++;
                for (String str : usedOnLevel)
                    set.remove(str);
            }

            if (word.equals(targetWord)) {
                if (ans.size() == 0)
                    ans.add(current);
                else if (ans.size() == ans.get(0).size())
                    ans.add(current);
            }

            String query = "";
            for (int i = 0; i < word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    query = word.substring(0, i) + ((char) ('a' + j)) + word.substring(i + 1, word.length());
                    if (set.contains(query)) {
                        ArrayList<String> temp = new ArrayList<>(current);
                        usedOnLevel.add(query);
                        temp.add(query);
                        queue.offer(temp);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        WordLadder2NotOptimized w = new WordLadder2NotOptimized();
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        ArrayList<ArrayList<String>> ans = w.findSequences(startWord, targetWord, wordList);
        for (ArrayList<String> i : ans)
            System.out.println(i);
    }
}
