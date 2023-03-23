package leetcodeContest.WeeklyContest335;

public class ProblemA {
    public int passThePillow(int n, int time) {
        return n - Math.abs(n - 1 - time % (n * 2 - 2));
    }
    public static void main(String[] args) {

    }
}
