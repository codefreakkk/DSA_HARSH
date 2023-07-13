package RANDOM_PROBLEM;

public class Leetcode_1219 {

    private int max = 0;

    private void solve(int row, int col, int current, int[][] grid, int[][] visited) {
        int n = grid.length, m = grid[0].length;

        if (row < 0 || col < 0 || row >= n || col >= m || visited[row][col] == 1 || grid[row][col] == 0) {
            max = Math.max(max, current);
            return;
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int val = grid[row][col];
        visited[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            solve(newRow, newCol, current + val, grid, visited);
        }
        visited[row][col] = 0;
    }

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    solve(i, j, 0, grid, visited);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
