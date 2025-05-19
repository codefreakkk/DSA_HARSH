package DSA_REVISION.Graph;

import java.util.*;

public class AlienDictonary {

    private int findVertexCount(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }
        return set.size();
    }

    public String findOrder(String[] words) {
        // code here
        int n = words.length;
        int V = findVertexCount(words);

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int length = Math.min(s1.length(), s2.length());
            for (int j = 0; j < length; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            for (int adjacentNode : adjList.get(i)) {
                indegree[adjacentNode]++;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);

            for (int adjacentNode : adjList.get(node)) {
                indegree[adjacentNode]--;
                if (indegree[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char ch = (char) (list.get(i) + ((int) 'a'));
            ans.append(ch);
        }
        return ans.toString();

    }

    public static void main(String[] args) {

    }
}
