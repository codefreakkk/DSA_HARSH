package leetcodeContest.WeeklyContest404;

public class ProblemA {

    private static int helper(int red, int blue) {
        int count = 0, i = 1;

        while (true) {
            if (i % 2 == 1) {
                if (red >= i) {
                    red -= i;
                }
                else {
                    break;
                }
            }
            else {
                if (blue >= i) {
                    blue -= i;
                }
                else {
                    break;
                }
            }
            i++;
            count++;
        }
        return count;
    }

    public static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red, blue), helper(blue, red));
    }

    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(2, 4));
    }
}
