package REVISION.GraphAlgos;

import java.util.*;

public class ArticulationPoint {
    private int timer = 1;
    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] low, int[] inTime,
                     int[] visited, int[] mark) {
        visited[node] = 1;
        inTime[node] = low[node] = timer++;

        int child = 0;
        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) continue;

            if (visited[adjNode] == 0) {
                dfs(adjNode, node, adj, low, inTime, visited, mark);
                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] >= inTime[node] && parent != -1)
                    mark[node] = 1;

                child++;
            }
            else low[node] = Math.min(low[node], inTime[adjNode]);
        }
        if (child > 1 && parent == -1) mark[node] = 1;
    }

    public ArrayList<Integer> articulationPoint(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] low = new int[V];
        int[] inTime = new int[V];
        int[] visited = new int[V];
        int[] mark = new int[V];

        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, -1, adj, low, inTime, visited, mark);

        for (int i = 0; i < V; i++) {
            if (mark[i] == 1)
                ans.add(i);
        }
        if (ans.size() == 0) {
            ans.add(-1);
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
