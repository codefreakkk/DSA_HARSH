package Graph;

import java.util.*;

public class TimeNeededToInformAllEmployees {

    private int dfs(int headId, List<List<Integer>> adj, int[] informTime) {
        int maxTime = 0;

        for (int node : adj.get(headId)) {
            int time = dfs(node, adj, informTime);
            maxTime = Math.max(time, maxTime);
        }
        return informTime[headId] + maxTime;
    }

    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }

        return dfs(headId, adj, informTime);
    }

    public static void main(String[] args) {

    }
}
