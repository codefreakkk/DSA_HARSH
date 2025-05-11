package DSA_REVISION.Graph;

import java.util.*;

public class _01Matrix {

    class Tupple {
        int row, col, distance;
        public Tupple(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private boolean valid(int row, int col, int[][] visited) {
        int n = visited.length, m = visited[0].length;

        return row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0;
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        Queue<Tupple> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = 1;
                    queue.offer(new Tupple(i, j, 0));
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        int[][] ans = new int[n][m];
        while (!queue.isEmpty()) {
            Tupple tupple = queue.poll();
            int row = tupple.row;
            int col = tupple.col;
            int distance = tupple.distance;

            ans[row][col] = distance;

            for (int i = 0; i < 4; i++) {
                int numRow = row + delRow[i];
                int numCol = col + delCol[i];

                if (valid(numRow, numCol, visited)) {
                    visited[numRow][numCol] = 1;
                    queue.offer(new Tupple(numRow, numCol, distance + 1));
                }
            }
        }
        return ans;
    }

}
