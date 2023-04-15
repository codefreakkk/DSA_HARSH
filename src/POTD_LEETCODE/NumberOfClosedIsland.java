package POTD_LEETCODE;

import Graph.NumberOfIslands;

public class NumberOfClosedIsland {

    private void dfs(int row, int col, int[][] grid, int[][] visited, int[] isValid) {
        if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1) {
            isValid[0] = 0;
            return;
        }

        visited[row][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (grid[newRow][newCol] == 0 && visited[newRow][newCol] == 0) {
                dfs(newRow, newCol, grid, visited, isValid);
            }
        }
    }

    public int closedIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) visited[i][j] = 1;
            }
        }

        // count components
        int[] isValid = {1};
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    dfs(i, j, grid, visited, isValid);
                    if (isValid[0] == 1) count++;
                    isValid[0] = 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfClosedIsland o = new NumberOfClosedIsland();
        int[][] nums = {
                {0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}
        };
        System.out.println(o.closedIslands(nums));
    }
}

//        [[0,0,1,1,0,1,0,0,1,0],
//        [1,1,0,1,1,0,1,1,1,0],
//        [1,0,1,1,1,0,0,1,1,0],
//        [0,1,1,0,0,0,0,1,0,1],
//        [0,0,0,0,0,0,1,1,1,0],
//        [0,1,0,1,0,1,0,1,1,1],
//        [1,0,1,0,1,1,0,0,0,1],
//        [1,1,1,1,1,1,0,0,0,0],
//        [1,1,1,0,0,1,0,1,0,1],
//        [1,1,1,0,1,1,0,1,1,0]]