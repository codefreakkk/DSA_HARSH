package Graph;

import java.util.*;

public class MakingALargestIsland {

    public boolean isValid(int row, int col, int[][] grid) {
        int n = grid.length;
        return (row >= 0 && row < n) && (col >= 0 && col < n);
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // connect the similar components
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int row = i + delRow[k];
                    int col = j + delCol[k];

                    if (isValid(row, col, grid) && grid[row][col] == 1) {
                        int currentNo = i * n + j;
                        int updatedNo = row * n + col;
                        ds.unionBySize(currentNo, updatedNo);
                    }
                }
            }
        }

        // go to all 0's and check for possible answer
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                if (grid[i][j] == 1)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int row = i + delRow[k];
                    int col = j + delCol[k];

                    if (isValid(row, col, grid) && grid[row][col] == 1) {
                        int updatedNo = row * n + col;
                        set.add(ds.findParent(updatedNo));
                    }
                }
                int total = 0;
                for (int parents : set) {
                    total += ds.size.get(parents);
                }

                count = Math.max(count, total + 1);
            }
        }

        // if whole grid contains only 1
        for (int i = 0; i < n * n; i++)
            count = Math.max(count, ds.size.get(ds.findParent(i)));

        return count;
    }
}