package Graph;

import java.util.*;

public class MinimumCostToMakeAtLeastOneValidPathInGrid {
    class Tupple {
        int row, col, cost;
        public Tupple(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public int minPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Tupple> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Tupple(0, 0, 0));

        int[][] visited = new int[n][m];

        while (!pq.isEmpty()) {
            Tupple tupple = pq.poll();
            int row = tupple.row;
            int col = tupple.col;
            int cost = tupple.cost;

            if (row == n - 1 && col == m - 1)
                return cost;

            visited[row][col] = 1;

            // left
            if (col - 1 >= 0 && visited[row][col - 1] == 0)
                pq.offer(new Tupple(row, col - 1, (grid[row][col] == 2 ? 0 : 1) + cost));

            // right
            if (col + 1 < m && visited[row][col + 1] == 0)
                pq.offer(new Tupple(row, col + 1, (grid[row][col] == 1 ? 0 : 1) + cost));

            // up
            if (row - 1 >= 0 && visited[row - 1][col] == 0)
                pq.offer(new Tupple(row - 1, col, (grid[row][col] == 4 ? 0 : 1) + cost));

            // down
            if (row + 1 < n && visited[row + 1][col] == 0)
                pq.offer(new Tupple(row + 1, col, (grid[row][col] == 3 ? 0 : 1) + cost));
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
