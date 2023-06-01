package POTD_LEETCODE;

import java.util.*;

public class ShortestPathInBinaryMatrix {

    class Tupple {
        int steps, row, col;
        public Tupple(int steps, int row, int col) {
            this.steps = steps;
            this.row = row;
            this.col = col;
        }
    }

    private boolean isValid(int[][] grid, int[][] distance, int row, int col, int steps) {
        int n = grid.length;
        return (row >= 0 && col >= 0) && (row < n && col < n) && (grid[row][col] == 0) && (steps + 1 < distance[row][col]);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] distance = new int[n][n];

        for (int[] nums : distance) Arrays.fill(nums, Integer.MAX_VALUE);
        distance[0][0] = 1;

        Queue<Tupple> queue = new LinkedList<>();
        queue.offer(new Tupple(1, 0, 0));

        while (!queue.isEmpty()) {
            Tupple element = queue.poll();
            int steps = element.steps;
            int row = element.row;
            int col = element.col;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = col + j;

                    if (isValid(grid, distance, newRow, newCol, steps)) {
                        if (newRow == n - 1 && newCol == n - 1) {
                            return steps + 1;
                        }
                        distance[newRow][newCol] = steps + 1;
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
