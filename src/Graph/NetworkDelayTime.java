package Graph;

import java.util.*;

public class NetworkDelayTime {
    class Pair {
        int node, weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTimes(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Pair(v, weight));
        }

        int max = (int) 1e9;
        int[] distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            distance[i] = max;

        distance[0] = -1;
        distance[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int time = pair.weight;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjTime = current.weight;

                if (time + adjTime < distance[adjNode]) {
                    distance[adjNode] = time + adjTime;
                    pq.offer(new Pair(adjNode, time + adjTime));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++)
            ans = Math.max(ans, distance[i]);

        if (ans == max)
            return -1;

        return ans;
    }

    public static void main(String[] args) {

    }
}
