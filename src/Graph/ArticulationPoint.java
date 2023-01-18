package Graph;

import java.util.*;

public class ArticulationPoint {

    private int timer = 1;
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] low,
                     int[] inTime, int[] mark) {
        visited[node] = 1;
        low[node] = inTime[node] = timer;
        timer++;

        int child = 0;
        for (int adjNode : adj.get(node)) {
            if (adjNode == parent)
                continue;

            if (visited[adjNode] == 0) {
                dfs(adjNode, node, adj, visited, low, inTime, mark);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] >= inTime[node] && parent != -1)
                    mark[node] = 1;

                child++;
            }
            else
                low[node] = Math.min(low[node], inTime[adjNode]);
        }
        if (child > 1 && parent == -1)
            mark[node] = 1;
    }
    public ArrayList<Integer> articulationPoint(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] low = new int[V];
        int[] inTime = new int[V];
        int[] mark = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, adj, visited, low, inTime, mark);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1)
                ans.add(i);
        }
        if (ans.size() == 0)
            ans.add(-1);

        return ans;
    }

    public static void main(String[] args) {

    }
}
