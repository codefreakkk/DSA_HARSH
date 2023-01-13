package Graph;

import java.util.*;

public class PathWithMinimumEfforts {
    class Tupple {
        int difference, row, col;
        public Tupple(int difference, int row, int col) {
            this.difference = difference;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEfforts(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                distance[i][j] = (int) 1e9;
        }
        distance[0][0] = 1;

        PriorityQueue<Tupple> queue = new PriorityQueue<>((a, b) -> a.difference - b.difference);
        queue.offer(new Tupple(0, 0, 0));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int difference = tupple.difference;
            int row = tupple.row;
            int col = tupple.col;

            if (row == n - 1 && col == m - 1)
                return difference;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newDifference = Math.abs(grid[newRow][newCol] - grid[row][col]);
                    int newEffort = Math.max(newDifference, difference);

                    if (newEffort < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newEffort;
                        queue.offer(new Tupple(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
