package Graph;

import java.util.*;

public class AlienDictonary {

    public List<Integer> topologicalSort(int v, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int adjacentNode : adj.get(i))
                indegree[adjacentNode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int adjacentNode : adj.get(node)) {
                indegree[adjacentNode]--;

                if (indegree[adjacentNode] == 0)
                    queue.offer(adjacentNode);
            }
        }
        return ans;
    }

    public String dict(String[] dict, int n, int v) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];
            int length = Math.min(str1.length(), str2.length());

            for (int ptr = 0; ptr < length; ptr++) {
                if (str1.charAt(ptr) != str2.charAt(ptr)) {
                    adj.get(str1.charAt(ptr) - 'a').add(str2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topologicalSort(v, adj);
        String ans = "";
        for (int i = 0; i < topo.size(); i++) {
            ans += (char) (topo.get(i) + ((int) 'a'));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
