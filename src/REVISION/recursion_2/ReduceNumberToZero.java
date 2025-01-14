package REVISION.recursion_2;

public class ReduceNumberToZero {

    private int solve(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 2 == 0) {
            return solve(n / 2, count + 1);
        }
        return solve(n - 1, count + 1);
    }

    public int numberOfSteps(int n) {
        return solve(n, 0);
    }

    public static void main(String[] args) {

    }
}
