package Graph;

import java.util.LinkedList;
import java.util.*;

public class GeekInAMaze {
    class Cell {
        int r, c, u, d;
        public Cell(int r, int c, int u, int d) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.d = d;
        }
    }

    public int numberOfCells(int n, int m, int R, int C, int U, int D, char[][] mat) {
        if (mat[R][C] == '#')
            return 0;

        int ans = 1;
        Queue<Cell> pq = new LinkedList<>();
        pq.offer(new Cell(R, C, U, D));
        mat[R][C] = '#';
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int r = cell.r;
            int c = cell.c;
            int u = cell.u;
            int d = cell.d;

            // left
            if (c - 1 >= 0 && mat[r][c - 1] == '.') {
                ans++;
                pq.offer(new Cell(r, c - 1, u, d));
                mat[r][c - 1] = '#';
            }

            // right
            if (c + 1 < m && mat[r][c + 1] == '.') {
                ans++;
                pq.offer(new Cell(r, c + 1, u, d));
                mat[r][c + 1] = '#';
            }

            // up
            if (u > 0 && r - 1 >= 0 && mat[r - 1][c] == '.') {
                ans++;
                pq.offer(new Cell(r - 1, c, u - 1, d));
                mat[r - 1][c] = '#';
            }

            // down
            if (d > 0 && r + 1 < n && mat[r + 1][c] == '.') {
                ans++;
                pq.offer(new Cell(r + 1, c, u, d - 1));
                mat[r + 1][c] = '#';
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
