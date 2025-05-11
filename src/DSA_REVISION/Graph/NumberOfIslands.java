package DSA_REVISION.Graph;

import java.util.*;

public class NumberOfIslands {

    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean valid(int row, int col, int[][] visited, char[][] grid) {
        int n = grid.length, m = grid[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0 && grid[row][col] == '1';
    }

    private void bfs(Pair node, int[][] visited, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(node);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            Pair currentNode = queue.poll();
            int row = currentNode.row;
            int col = currentNode.col;

            for (int i = 0; i < 4; i++) {
                int numRow = row + delRow[i];
                int numCol = col + delCol[i];

                if (valid(numRow, numCol, visited, grid)) {
                    queue.offer(new Pair(numRow, numCol));
                    visited[numRow][numCol] = 1;
                }
            }
        }
    }


    public int numsIsland(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n + 1][m + 1];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    visited[i][j] = 1;
                    bfs(new Pair(i, j), visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
