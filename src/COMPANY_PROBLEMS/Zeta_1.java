package COMPANY_PROBLEMS;
import java.math.BigInteger;
import java.util.*;

public class Zeta_1 {

    private int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;

        if (m == 1) return 0;

        while (a > 1) {
            int q = a / m;
            int t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        if (x < 0) {
            x += m0;
        }

        return x;
    }

    private boolean solve(int row, int col, int n, int m, char[][] grid) {
        if (row == n - 1 && col == m - 1) {
            return true;
        }
        boolean down = false, right = false;
        if (row + 1 < n && grid[row + 1][col] != '#') {
            down = solve(row + 1, col, n, m, grid);
            if (down) return true;
        }
        if (col + 1 < m && grid[row][col + 1] != '#') {
            right = solve(row, col + 1, n, m, grid);
            if (right) return true;
        }
        return down || right;
    }

    public int findProbability(int n, int m, char[][] grid) {
        int count = 0, totalEmptyCells = 0;

        for (char[] it : grid) {
            for (char ch : it) {
                if (ch == '_') {
                    totalEmptyCells++;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (grid[i][j] != '#') {
                    char temp = grid[i][j];
                    grid[i][j] = '#';

                    if (!solve(0, 0, n, m, grid)) {
                        count++;
                    }
                    grid[i][j] = temp;
                }
            }
        }

        int MOD = 1000000007;
        // Calculate probability using modulo inverse
        if (count > 0) {
            count += 2;
            int inv = modInverse(totalEmptyCells, MOD) % MOD;
            int result = (count * inv) % MOD;
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        Zeta_1 o = new Zeta_1();
        int n = 5, m = 5;
        char[][] grid = {
                {'_', '_', '_', '#', '#'},
                {'_', '#', '_', '#', '#'},
                {'_', '_', '_', '_', '_'},
                {'#', '#', '_', '#', '_'},
                {'#', '#', '_', '_', '_'}
        };
//        char[][] grid = {{'_', '#', '_'}};
        System.out.println(o.findProbability(n, m, grid));
    }
}


