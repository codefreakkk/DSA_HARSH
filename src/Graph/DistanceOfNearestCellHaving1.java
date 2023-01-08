package Graph;

import java.util.*;

public class DistanceOfNearestCellHaving1 {
    class Tupple {
        int row, col, steps;
        public Tupple(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public boolean isValid(int row, int col, int[][] visited, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] == 0 && grid[row][col] == 0);
    }

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];
        Queue<Tupple> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
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
            ans[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (isValid(newRow, newCol, visited, grid)) {
                    visited[newRow][newCol] = 1;
                    queue.offer(new Tupple(newRow, newCol, steps + 1));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DistanceOfNearestCellHaving1 o = new DistanceOfNearestCellHaving1();
        int[][] grid = {{1,0,1},{1,1,0},{1,0,0}};
        int[][] ans = o.nearest(grid);
        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
    }
}
