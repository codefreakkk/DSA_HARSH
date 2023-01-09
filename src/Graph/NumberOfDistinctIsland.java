package Graph;

import java.util.*;

public class NumberOfDistinctIsland {

    public String convertToString(int row, int col) {
        return String.valueOf(row) + "" + String.valueOf(col);
    }

    public boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] == 0 && grid[row][col] == 1);
    }

    public void dfs(int baseRow, int baseCol, int row, int col, int[][] grid, int[][] visited, ArrayList<String> list) {
        visited[row][col] = 1;
        list.add(convertToString(row - baseRow, col - baseCol));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // check in 4 directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (isValid(newRow, newCol, grid, visited)) {
                dfs(baseRow, baseCol, newRow, newCol, grid, visited, list);
            }
        }
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, i, j, grid, visited, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {

    }
}
