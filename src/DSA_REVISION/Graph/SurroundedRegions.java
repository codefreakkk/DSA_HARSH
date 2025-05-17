package DSA_REVISION.Graph;

public class SurroundedRegions {

    private boolean valid(int row, int col, char[][] board, int[][] visited) {
        int n = board.length, m = board[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0 && board[row][col] == 'O';
    }

    private void dfs(int row, int col, char[][] board, int[][] visited) {
        visited[row][col] = 1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int numRow = row + delRow[i];
            int numCol = col + delCol[i];

            if (valid(numRow, numCol, board, visited)) {
                dfs(numRow, numCol, board, visited);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (board[i][0] == '0') {
                dfs(i, 0, board, visited);
            }
            if (board[i][n - 1] == '0') {
                dfs(i, m - 1, board, visited);
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, visited);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
