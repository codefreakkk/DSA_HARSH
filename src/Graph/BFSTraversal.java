package Graph;

import java.util.*;

public class BFSTraversal {
    public ArrayList<Integer> bfsTraversal(int v, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[v + 1];
        int startingIndex = 1;
        visited[startingIndex] = 1;
        queue.offer(startingIndex);

        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int i : adj.get(node)) {
                if (visited[i] != 1) {
                    visited[i] = 1;
                    queue.offer(i);
                }
            }
        }
        return ans;
    }


    public void adjacencyList(int n, int m, ArrayList<ArrayList<Integer>> adj) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public static void main(String[] args) {
        BFSTraversal o = new BFSTraversal();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 9, m = 9;
        o.adjacencyList(n, m, adj);
        ArrayList<Integer> bfs = o.bfsTraversal(n, adj);
        System.out.println(bfs);
    }
}
