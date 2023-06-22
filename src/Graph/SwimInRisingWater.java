package Graph;
import java.util.*;

public class SwimInRisingWater {

    class Tupple {
        int row, col, time;
        public Tupple(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }
    }

    private boolean isValid(int n, int row, int col, int[][] visited) {
        return(row >= 0 && row < n) && (col >= 0 && col < n) && (visited[row][col] == 0);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];

        PriorityQueue<Tupple> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Tupple(grid[0][0], 0, 0));

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int ans = -1;
        while (!pq.isEmpty()) {
            Tupple tupple = pq.poll();
            int row = tupple.row;
            int col = tupple.col;
            int time = tupple.time;

            if (row == n - 1 && col == n - 1) {
                ans = time;
                break;
            }
            visited[row][col] = 1;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (isValid(n, newRow, newCol, visited)) {
                    int newTime = Math.max(time, grid[newRow][newCol]);
                    pq.offer(new Tupple(newTime, newRow, newCol));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

