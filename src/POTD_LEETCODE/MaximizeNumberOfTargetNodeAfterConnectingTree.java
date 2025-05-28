package POTD_LEETCODE;

import java.util.*;

public class MaximizeNumberOfTargetNodeAfterConnectingTree {

    class Pair {
        int node, count;
        public Pair(int node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    private int findNumberOfNodes(int[][] edges) {
        int max = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            for (int node : edge) {
                max = Math.max(max, node);
            }
        }
        return max;
    }

    private void constructGraph(int[][] edges, List<List<Integer>> adjList) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    private int bfs(int node, int V, int k,  List<List<Integer>> adjList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(node, 0));

        int[] visited = new int[V + 1];
        visited[node] = 1;

        int numberOfNodes = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currentNode = pair.node;
            int count = pair.count;
            if (count == k) {
                return numberOfNodes;
            }

            for (int adjacentNode : adjList.get(currentNode)) {
                if (visited[adjacentNode] == 0) {
                    numberOfNodes++;
                    visited[adjacentNode] = 1;
                    queue.offer(new Pair(adjacentNode, count + 1));
                }
            }
        }
        return numberOfNodes;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = findNumberOfNodes(edges1);
        int m = findNumberOfNodes(edges2);

        List<List<Integer>> adjList1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList1.add(new ArrayList<>());
        }
        List<List<Integer>> adjList2 = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            adjList2.add(new ArrayList<>());
        }
        constructGraph(edges1, adjList1);
        constructGraph(edges2, adjList2);

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int numberOfNodes = bfs(i, n, k, adjList1);
            map1.put(i, numberOfNodes);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        int max = 0;
        for (int i = 0; i <= m; i++) {
            if (k == 0) {
                break;
            }
            int numberOfNodes = bfs(i, m, k - 1, adjList2);
            max = Math.max(max, numberOfNodes);
        }

        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            answer[i] = map1.get(i) + max;
        }
        return answer;
    }
}
