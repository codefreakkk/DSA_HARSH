package DSA_REVISION.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean valid(int row, int col, int[][] visited, int[][] grid) {
        int n = grid.length, m = grid[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0 && grid[row][col] == 1;
    }

    public int numOfEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        // traverse column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.offer(new Pair(i, 0));
            }
            if (grid[i][m - 1] == 1) {
                queue.offer(new Pair(i, m - 1));
            }
        }

        // traverse row
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                queue.offer(new Pair(0, i));
            }
            if (grid[m - 1][i] == 1) {
                queue.offer(new Pair(m - 1, i));
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            visited[row][col] = 1;

            for (int i = 0; i < 4; i++) {
                int numRow = row + delRow[i];
                int numCol = col + delCol[i];

                if (valid(numRow, numCol, visited, grid)) {
                    queue.offer(new Pair(numRow, numCol));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
