package DynamicProgramming;

import java.util.Arrays;

public class NinjasTraining {

    // memoization
    private int solve(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxi = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(points[day][i], maxi);
                }
            }
            return maxi;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int maxi = Integer.MIN_VALUE;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int merit = points[day][task] + solve(day - 1, task, points, dp);
                maxi = Math.max(maxi, merit);
            }
        }
        return dp[day][last] = maxi;
    }

    // memoization
    public int maxPoints(int[][] points, int N) {
        int[][] dp = new int[N][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(N - 1, 3, points, dp);
    }

    // tabulation
    public int maxPointsTabulation(int[][] points, int N) {
        int[][] dp = new int[N][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < N; day++) {
            for (int last = 0; last <= 3; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int merit = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], merit);
                    }
                }
            }
        }
        return dp[N - 1][3];
    }

    public static void main(String[] args) {

    }
}
