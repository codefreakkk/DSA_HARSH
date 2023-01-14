package Graph;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    class Pair {
        int node, steps;
        public Pair(int steps, int node) {
            this.node = node;
            this.steps = steps;
        }
    }

    public int countPaths(int n, List<List<Integer>> grid) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> list : grid) {
            int u = list.get(0);
            int v = list.get(1);
            int time = list.get(2);
            adj.get(u).add(new Pair(time, v));
            adj.get(v).add(new Pair(time, u));
        }

        int mod = (int) 10e9 + 7;
        int[] ways = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
            distance[i] = (int) 1e9;

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.steps - b.steps);
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int steps = pair.steps;

            for (Pair current : adj.get(node)) {
                int adjNode = current.node;
                int adjNodeSteps = current.steps;
                int totalSteps = steps + adjNodeSteps;

                if (totalSteps < distance[adjNode]) {
                    distance[adjNode] = totalSteps;
                    ways[adjNode] = ways[node];
                    queue.offer(new Pair(distance[adjNode], adjNode));
                }
                else if (totalSteps == distance[adjNode]) {
                    ways[adjNode] = (ways[node] + ways[adjNode]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {

    }
}
