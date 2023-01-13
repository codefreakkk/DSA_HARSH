package Graph;

import java.util.*;

public class ShortestPathInBinaryMatrixLeetcode {
    class Tupple {
        int distance, row, col;
        public Tupple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int steps, int[][] grid, int[][] distance) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (grid[row][col] == 0) && (steps + 1 < distance[row][col]);
    }

    public int shortestPathInBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0][0] == 1)
            return -1;

        if (grid.length == 1 && grid[0][0] == 0)
            return 1;

        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                distance[i][j] = (int) 1e9;
        }
        distance[0][0] = 1;

        Queue<Tupple> queue = new LinkedList<>();
        queue.offer(new Tupple(1, 0, 0));

        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int steps = tupple.distance;
            int row = tupple.row;
            int col = tupple.col;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = col + j;

                    if (isValid(newRow, newCol, steps, grid, distance)) {
                        distance[newRow][newCol] = steps + 1;
                        if (newRow == n - 1 && newCol == n - 1)
                            return steps + 1;

                        queue.offer(new Tupple(steps + 1, newRow, newCol));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
