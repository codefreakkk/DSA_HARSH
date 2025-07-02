package DSA_REVISION.Graph;

import java.util.*;

public class PrimsAlgorithm {

    static class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adjList) {

        int[] visited = new int[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);
        pq.offer(new Pair(0, 0));

        int sum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node  = pair.node;
            int weight  = pair.weight;

            if (visited[node] == 1) {
                continue;
            }
            visited[node] = 1;
            sum += weight;

            for (int[] adjPair : adjList.get(node)) {
                int adjNode = adjPair[0];
                int adjWeight = adjPair[1];

                if (visited[adjNode] == 0) {
                    pq.offer(new Pair(adjNode, adjWeight));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
