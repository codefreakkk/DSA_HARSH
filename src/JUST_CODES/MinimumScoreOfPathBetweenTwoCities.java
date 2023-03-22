package JUST_CODES;

import java.util.*;

public class MinimumScoreOfPathBetweenTwoCities {

    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private int bfs(int n, List<List<Pair>> adjList) {
        int[] visited = new int[n + 1];
        int max = (int) 1e9;
        Arrays.fill(visited, max);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0));

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int weight = pair.weight;
            visited[node] = 1;

            if (node != 1) {
                min = Math.min(min, weight);
            }

            for (Pair it : adjList.get(node)) {
                int adjNode = it.node;
                int adjWeight = it.weight;
                if (visited[adjNode] != 1) {
                    queue.offer(new Pair(adjNode, adjWeight));
                }
            }
        }
        return min;
    }

    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] row : roads) {
            int u = row[0];
            int v = row[1];
            int weight = row[2];
            adjList.get(u).add(new Pair(v, weight));
            adjList.get(v).add(new Pair(u, weight));
        }
        return bfs(n, adjList);
    }

    public static void main(String[] args) {

    }
}
