package leetcodeContest.WeeklyContest360;

public class ProblemA {

    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0;

        for (char it : moves.toCharArray()) {
            if (it == 'L') {
                left--;
                right--;
            }
            else if (it == 'R') {
                left++;
                right++;
            }
            else {
                left--;
                right++;
            }
        }
        return Math.max(Math.abs(left), Math.abs(right));
    }

    public static void main(String[] args) {

    }
}
