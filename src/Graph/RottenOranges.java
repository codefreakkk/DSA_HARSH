package Graph;

import java.util.*;

public class RottenOranges {
    class Pair {
        int row, col, time;
        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length, m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] != 2 && grid[row][col] == 1);
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int finalTime = 0, count = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.peek();
            queue.remove();

            int row = pair.row;
            int col = pair.col;
            int time = pair.time;

            finalTime = Math.max(finalTime, time);
            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (isValid(newRow, newCol, grid, visited)) {
                    visited[newRow][newCol] = 2;
                    queue.offer(new Pair(newRow, newCol, time + 1));
                    count++;
                }
            }
        }
        return fresh == count ? finalTime : -1;
    }

    public static void main(String[] args) {
        RottenOranges o = new RottenOranges();
        int[][] grid = {{0,1,2},{0,1,2},{2,1,1}};
        System.out.println(o.orangesRotting(grid));
    }
}
