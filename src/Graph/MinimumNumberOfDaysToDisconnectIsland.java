package Graph;

public class MinimumNumberOfDaysToDisconnectIsland {
    private int timer = 0;
    private boolean articulation = false;

    private boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (grid[row][col] == 1);
    }

    private void dfs(int row, int col, int parentRow, int parentCol, int[][] low, int[][] inTime, int[][] grid, int[][] visited) {
        visited[row][col] = 1;
        low[row][col] = inTime[row][col] = timer++;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int child = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if (isValid(newRow, newCol, grid, visited)) {
                if (visited[newRow][newCol] == 0) {
                    child++;
                    dfs(newRow, newCol, row, col, low, inTime, grid, visited);
                    low[row][col] = Math.min(low[row][col], low[newRow][newCol]);
                    if (low[newRow][newCol] >= inTime[row][col] && parentRow != -1)
                        articulation = true;
                }
                else
                    low[row][col] = Math.min(inTime[newRow][newCol], low[row][col]);
            }
        }

        // check for parent
        if (parentRow == -1 && child > 1)
            articulation = true;
    }

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] low = new int[n][m];
        int[][] inTime = new int[n][m];

        int lands = 0, isLands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    lands++;
                    if (visited[i][j] == 0) {
                        isLands++;
                        dfs(i, j, -1, -1, low, inTime, grid, visited);
                    }
                }
            }
        }
        if (isLands == 0 || isLands > 1) return 0;
        if (lands == 1 || articulation) return 1;
        return 2;
    }


    public static void main(String[] args) {

    }
}
