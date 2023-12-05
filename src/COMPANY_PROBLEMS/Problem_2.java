package COMPANY_PROBLEMS;
import java.util.*;

public class Problem_2 {
    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }



    private boolean isValid(int row, int col, int n, int m)
    {
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return false;
        }
        return true;
    }

    public int findShortestPath(int grid[][]) {

        int n = grid.length, m = grid[0].length;

        int rowNum[] = {-1, 0, 0, 1};
        int colNum[] = {0, -1, 1, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 4; k++)
                        if (isValid(i + rowNum[k], j + colNum[k], n, m)) {
                            grid[i + rowNum[k]][j + colNum[k]] = -1;
                        }
                }
            }
        }
        // mark all found adjacent cells as unsafe
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1)
                    grid[i][j] = 0;
            }
        }

        int dist[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                dist[i][j] = -1;
        }
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.add(new Pair(i, 0));
                dist[i][0] = 0;
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int distance = dist[pair.row][pair.col];

            int row = pair.row;
            int col = pair.col;

            for (int ki = 0; ki < 4; ki++) {
                int newRow = row + rowNum[ki];
                int newCol = col + colNum[ki];
                if (isValid(newRow, newCol, n, m) && dist[newRow][newCol] == -1 && grid[newRow][newCol] == 1) {
                    dist[newRow][newCol] = distance + 1;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }

        int ans = (int) 1e9;
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1 && dist[i][m - 1] != -1) {
                ans = Math.min(ans, dist[i][m - 1]);
            }
        }
        if (ans == (int) 1e9) {
            return -1;
        }
        return ans;
    }



        public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 1}
        };
        Problem_2 o = new Problem_2();
            System.out.println(o.findShortestPath(matrix));
    }
}
