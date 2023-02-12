package Graph;
import java.util.*;
public class MinimumFuelCostToReportToCapital {
    private int ans = 0;
    private int dfs(int node, int parent, List<List<Integer>> adjList, int seats) {
        int people = 1;
        for (int adjNode : adjList.get(node)) {
            if (adjNode == parent) continue;
            people += dfs(adjNode, node, adjList, seats);
        }
        if (node > 0) {
            ans += (people + seats - 1) / seats;
        }
        return people;
    }
    public long minimumFuelCost(int[][] road, int seats) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = road.length;
        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : road) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        dfs(0, -1, adjList, seats);
        return ans;
    }
    public static void main(String[] args) {
        MinimumFuelCostToReportToCapital o = new MinimumFuelCostToReportToCapital();
        int[][] road = {
                {0,1},{0,2},{0,3}
        };
        int seats = 5;
        System.out.println(o.minimumFuelCost(road, seats));
    }
}
