package Graph;

import java.util.*;


// gfg version
public class NumberOfIslands {

    class Pairs {
        int row, col;
        public Pairs(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int row, int col, char[][] grid, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (grid[row][col] == '1' && visited[row][col] == 0);
    }

    public void bfs(int row, int col, char[][] grid, int[][] visited) {
        Queue<Pairs> queue = new LinkedList<>();
        visited[row][col] = 1;
        queue.offer(new Pairs(row, col));

        while (!queue.isEmpty()) {
            Pairs pair = queue.poll();
            int nRow = pair.row;
            int nCol = pair.col;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = nRow + i;
                    int newCol = nCol + j;
                    if (isValid(newRow, newCol, grid, visited)) {
                        visited[newRow][newCol] = 1;
                        queue.offer(new Pairs(newRow, newCol));
                    }
                }
            }
        }
    }

    public int numIsland(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (visited[i][j] == 0) {
                        count++;
                        bfs(i, j, grid, visited);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'0','1'},{'1','0'},{'1','1'},{'1','0'}
        };
        NumberOfIslands o = new NumberOfIslands();
        System.out.println(o.numIsland(grid));
    }
}
