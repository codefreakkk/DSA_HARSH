package Graph;

import java.util.*;

public class  _01Matrix {
    class Tupple {
        int row, col, steps;
        public Tupple(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] == 0 && grid[row][col] == 1);
    }

    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Tupple> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Tupple(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int row = tupple.row;
            int col = tupple.col;
            int steps = tupple.steps;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(newRow, newCol, grid, visited)) {
                    int finalStep = steps + 1;
                    ans[newRow][newCol] = finalStep;
                    visited[newRow][newCol] = 1;
                    queue.offer(new Tupple(newRow, newCol, finalStep));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        _01Matrix o = new _01Matrix();
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] ans = o.updateMatrix(grid);
        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
    }
}
