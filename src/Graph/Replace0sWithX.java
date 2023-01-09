package Graph;

// leetcode problem name - surrounded regions
// gfg problem name - replace 0 with x

public class Replace0sWithX {
    public boolean isValid(int row, int col, char[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] == 0 && grid[row][col] == 'O');
    }
    public void dfs(int row, int col, char[][] grid, int[][] visited) {
        visited[row][col] = 1;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (isValid(newRow, newCol, grid, visited))
                dfs(newRow, newCol, grid, visited);
        }
    }

    public char[][] fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O')
                dfs(0, j, grid, visited);

            int lastRow = n - 1;
            if (grid[lastRow][j] == 'O')
                dfs(lastRow, j,grid, visited);
        }

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O')
                dfs(i, 0, grid, visited);

            int lastCol = m - 1;
            if (grid[i][lastCol] == 'O')
                dfs(i, lastCol, grid, visited);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 'O')
                    grid[i][j] = 'X';
            }
        }
        return grid;
    }

    public static void main(String[] args) {

    }
}
