package Graph;

import java.util.*;

public class NumberOfProvinces {
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i : adjList.get(current)) {
                if (visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        visited[node] = 1;
        for (int i : adjList.get(node)) {
            if (visited[i] == 0)
                dfs(i, adjList, visited);
        }
    }

    public static void convertToAdjacencyList(int v, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i < v; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }

    public static int numberOfProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        convertToAdjacencyList(v, adj, adjList);
        int[] visited = new int[v];

        int count = 0;
        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
