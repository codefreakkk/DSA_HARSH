package JUST_CODES;

public class JP_MORGAN_1 {

    private static boolean solve(int a, int b, int c, int d) {
        if (a == c && b == d) return true;
        if (a > c || b > d) return false;

        boolean left = solve(a + b, b, c, d);
        boolean right = solve(a, a + b, c, d);

        return left || right;
    }

    public static String isPossible(int a, int b, int c, int d) {
        return solve(a, b, c, d) == true ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(isPossible(1, 4, 5, 9));
    }
}
