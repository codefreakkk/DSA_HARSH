package Graph;

import java.util.*;

public class EventualSafeState {
    public boolean dfs(int node, List<List<Integer>> adj, int[] visited, int[] pathVisited, int[] check) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int adjacentNode : adj.get(node)) {
            if (visited[adjacentNode] == 0) {
                if (dfs(adjacentNode, adj, visited, pathVisited, check))
                    return true;
            }
            else if (pathVisited[adjacentNode] == 1)
                return true;
        }
        check[node] = 1;
        pathVisited[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        int[] visited = new int[v];
        int[] pathVisited = new int[v];
        int[] check = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0)
                dfs(i, adj, visited, pathVisited, check);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (check[i] == 1)
                ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
