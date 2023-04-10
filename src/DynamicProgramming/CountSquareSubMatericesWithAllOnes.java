package DynamicProgramming;

import java.util.Arrays;

public class CountSquareSubMatericesWithAllOnes {

    public static int countSquares(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) dp[i][0] = nums[i][0];
        for (int j = 0; j < m; j++) dp[0][j] = nums[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums[i][j] == 0) dp[i][j] = 0;
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1,1,1},
        {1,1,1,1},
        {0,1,1,1}};
        System.out.println(countSquares(nums));
    }
}
