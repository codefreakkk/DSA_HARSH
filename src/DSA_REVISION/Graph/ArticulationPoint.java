package DSA_REVISION.Graph;

import java.util.*;

public class ArticulationPoint {

    int timer = 1;

    private void dfs(int node, int parent, int[] inTime, int[] low, int[] visited, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        inTime[node] = timer;
        low[node] = timer;
        timer++;
        visited[node] = 1;

        int child = 0;
        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                dfs(adjacentNode,  node, inTime, low, visited, mark, adj);
                low[node] = Math.min(low[adjacentNode], low[node]);
                if (low[adjacentNode] >= inTime[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(inTime[adjacentNode], low[node]);
            }
        }

        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }

    public ArrayList<Integer> articulationPoint(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inTime = new int[V];
        int[] low = new int[V];
        int[] visited = new int[V];
        int[] mark = new int[V];

        dfs(0, -1, inTime, low, visited, mark, adj);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
