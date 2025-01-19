package REVISION.recursion_2;

public class CountAllPathsInMaze {

    private static boolean checkBoundaries(int row, int col, int[][] temp) {
        int n = temp.length, m = temp[0].length;
        if (row < 0 || row >= n || col < 0 || col >= m || temp[row][col] == 1) {
            return true;
        }
        return false;
    }

    private static int solve(int row, int col, int[][] temp, int[][] nums) {
        int n = nums.length, m = nums[0].length;
        if (checkBoundaries(row, col, temp)) {
            return 0;
        }
        if (row == n - 1 && col == m - 1) {
            return 1;
        }
        temp[row][col] = 1;

        int count = 0;
        count += solve(row, col + 1, temp, nums); // right
        count += solve(row + 1, col, temp, nums); // down
        count += solve(row - 1, col, temp, nums); // up
        count += solve(row, col - 1, temp, nums); // left

        temp[row][col] = 0;
        return count;
    }

    public static int countAllPaths(int[][] nums) {
        int n = nums.length, m = nums[0].length;
        int[][] temp = new int[n][m];
        return solve(0, 0, temp, nums);
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 0},
                {0, 0}
        };
        System.out.println(CountAllPathsInMaze.countAllPaths(nums));
    }
}
