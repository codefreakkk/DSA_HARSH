package leetcodeContest.Biweekly99;

public class ProblemB {
    public static long coloredCells(int n) {
        return (long) (n - 1) * 2 * n + 1;
    }
    public static void main(String[] args) {
        System.out.println(coloredCells(2));
    }
}
