package leetcodeContest.Biweekly102;

import java.util.Arrays;

public class ProblemA {

    private int getMaxLength(int num) {
        int count = 0, temp = num;
        if (num < 0) temp = -temp;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        if (num < 0) return count + 1;
        return count;
    }

    public int[] findColumnWidth(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                int length = getMaxLength(grid[j][i]);
                count = Math.max(length, count);
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{1}, {22}, {-333}};
    }
}
