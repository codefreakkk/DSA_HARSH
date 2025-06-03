package DSA_REVISION.Graph;

import java.util.*;

public class ShortestPathInBinaryMatrix {

    class Tupple {
        int row, col, distance;
        public Tupple(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    private boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        return row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int n = grid.length;

        Queue<Tupple> queue = new LinkedList<>();
        queue.offer(new Tupple(0, 0, 1));

        while (!queue.isEmpty()) {
            Tupple current = queue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int numRow = row + i;
                    int numCol = col + j;

                    if (isValid(row, col, grid)) {
                        queue.offer(new Tupple(numRow, numCol, distance + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
