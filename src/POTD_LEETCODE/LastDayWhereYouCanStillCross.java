package POTD_LEETCODE;
import java.util.*;

public class LastDayWhereYouCanStillCross {

    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean isValid(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        return row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 0 && grid[row][col] == 0;
    }

    private boolean bfs(int row, int col, int[][] grid, int[][] visited) {
        int n = grid.length;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;

            if (r == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];

                if (isValid(newRow, newCol, grid, visited)) {
                    visited[newRow][newCol] = 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }
        return false;
    }

    public int lastDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length - 1, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int[][] grid = new int[row][col];
            for (int index = 0; index <= mid; index++) {
                int x = cells[index][0] - 1;
                int y = cells[index][1] - 1;
                grid[x][y] = 1;
            }

            boolean flag = false;
            for (int i = 0; i < col; i++) {
                int[][] visited = new int[row][col];

                if (grid[0][i] == 0) {
                    if (bfs(0, i, grid, visited)) {
                        low = mid + 1;
                        ans = mid + 1;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {
                high = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LastDayWhereYouCanStillCross o = new LastDayWhereYouCanStillCross();
        int row = 2, col = 2;
        int[][] cells = { {1, 1}, {2, 1}, {1, 2}, {2, 2} };
        System.out.println(o.lastDayToCross(row, col, cells));
    }
}
