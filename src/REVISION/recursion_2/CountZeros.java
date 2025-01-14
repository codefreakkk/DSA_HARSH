package REVISION.recursion_2;

public class CountZeros {

    private static int count(int n, int counter) {
        if (n == 0) {
            return counter;
        }
        int num = n % 10;
        if (num == 0) {
            return count(n / 10, counter + 1);
        }
        return count(n / 10, counter);
    }

    public static int countZeros(int n) {
        return count(n, 0);
    }

    public static void main(String[] args) {
        int ans = CountZeros.countZeros(30204);
        System.out.println(ans);
    }
}
