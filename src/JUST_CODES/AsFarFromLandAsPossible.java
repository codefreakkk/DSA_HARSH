package JUST_CODES;
import java.util.*;
public class AsFarFromLandAsPossible {
    class Tupple {
        int count, row, col;
        public Tupple(int count, int row, int col) {
            this.count = count;
            this.row = row;
            this.col = col;
        }
    }

    public boolean isValid(int n, int m, int row, int col, int[][] visited) {
        return (row >= 0 && row < n) && (col >= 0 && col < m) && (visited[row][col] == 0);
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<Tupple> pq = new PriorityQueue<>((a, b) -> a.count - b.count);
        int[][] visited = new int[n][m];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    pq.offer(new Tupple(0, i, j));
                    visited[i][j] = 1;
                    cnt++;
                }
            }
        }

        if (cnt == n * m || cnt == 0)
            return -1;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int max = -1;

        while (!pq.isEmpty()) {
            Tupple tupple = pq.poll();
            int count = tupple.count;
            int row = tupple.row;
            int col = tupple.col;
            max = Math.max(max, count);

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];
                if (isValid(n, m, newRow, newCol, visited)) {
                    visited[newRow][newCol] = 1;
                    pq.offer(new Tupple(count + 1, newRow, newCol));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        AsFarFromLandAsPossible o = new AsFarFromLandAsPossible();
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println(o.maxDistance(grid));
    }
}
