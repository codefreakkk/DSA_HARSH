package REVISION.recursion_2;

public class MazeProblems {

    private static int solve(int row, int col, int[][] maze) {
        int n = maze.length, m = maze[0].length;
        if (row == n - 1 && col == m - 1) {
            return 1;
        }
        if (row >= n || col >= m) {
            return 0;
        }

        int count = 0;
        count += solve(row + 1, col, maze);
        count += solve(row, col + 1, maze);
        return count;
    }

    public static int countPaths(int[][] maze) {
        int n = maze.length, m = maze[0].length;
        return solve(0, 0, maze);
    }

    public static void main(String[] args) {
        int[][] maze = new int[2][2];
        System.out.println(countPaths(maze));
    }
}
