package Graph;

import java.util.*;

public class ShortestDistanceInBinaryMaze {
    class Pair {
        int distance, row, col;
        public Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int steps, int[][] grid, int[][] distance) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (grid[row][col] == 1) && (steps + 1 < distance[row][col]);
    }

    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];

        if (destination[0] == source[0] && destination[1] == source[1])
            return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                distance[i][j] = (int) 1e9;
        }
        distance[source[0]][source[1]] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, source[0], source[1]));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int steps = pair.distance;
            int row = pair.row;
            int col = pair.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, steps, grid, distance)) {
                    distance[newRow][newCol] = steps + 1;
                    if (destination[0] == newRow && destination[1] == newCol) {
                        return steps + 1;
                    }
                    queue.offer(new Pair(steps + 1, newRow, newCol));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
