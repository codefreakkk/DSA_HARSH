package DSA_REVISION.Graph;

import java.util.*;

public class PathWithMinimumEffort {

    class Tupple {
        int row, col, difference;
        public Tupple(int row, int col, int difference) {
            this.row = row;
            this.col = col;
            this.difference = difference;
        }
    }

    private boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public int minimumEffortPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        distance[0][0] = 0;

        PriorityQueue<Tupple> pq = new PriorityQueue<>((p1, p2 ) -> p1.difference - p2.difference);
        pq.offer(new Tupple(0, 0, 0));

        int[] delRow = {0, 1, 0, -1};
        int[] delCol = {1, 0, -1, 0};

        while (!pq.isEmpty()) {
            Tupple current = pq.poll();
            int row = current.row;
            int col = current.col;
            int difference = current.difference;

            if (row == n - 1 && col == m - 1) {
                return distance[row][col];
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, grid)) {
                    int adjacentDifference = Math.abs(grid[row][col] - grid[newRow][newCol]);
                    int maxDiff = Math.max(difference, adjacentDifference);

                    if (maxDiff < distance[newRow][newCol]) {
                        pq.offer(new Tupple(newRow, newCol, maxDiff));
                        distance[newRow][newCol] = maxDiff;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
