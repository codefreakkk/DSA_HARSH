package contests.leetcode.WeeklyContest328;

import java.util.Arrays;

public class ProblemB {
    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        for (int k = 0; k < queries.length; k++) {
            for (int i = queries[k][0]; i <= queries[k][2]; i++) {
                for (int j = queries[k][1]; j <= queries[k][3]; j++)
                    ans[i][j]++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] nums = {
                {1, 1, 2, 2},
                {0, 0, 1, 1}
        };
        int n = 3;
        int[][] ans = rangeAddQueries(n, nums);
        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
    }
}
