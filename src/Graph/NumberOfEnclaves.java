package Graph;

import java.util.*;

public class NumberOfEnclaves {
    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] == 0 && grid[row][col] == 1);
    }

    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        // mark row 1's
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                queue.offer(new Pair(0, j));
                visited[0][j] = 1;
            }

            int lastRow = n - 1;
            if (grid[lastRow][j] == 1) {
                queue.offer(new Pair(lastRow, j));
                visited[lastRow][j] = 1;
            }
        }

        // mark col 1's
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new Pair(i, 0));
                visited[i][0] = 1;
            }

            int lastCol = m - 1;
            if (grid[i][lastCol] == 1) {
                queue.offer(new Pair(i, lastCol));
                visited[i][lastCol] = 1;
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};


        // bfs
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, grid, visited)) {
                    visited[newRow][newCol] = 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }

        // traverse for counting ans
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1)
                    ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
