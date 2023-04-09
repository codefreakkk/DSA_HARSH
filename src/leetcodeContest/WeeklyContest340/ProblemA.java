package leetcodeContest.WeeklyContest340;

public class ProblemA {

    private int isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return 0;
        }
        return num;
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, isPrime(nums[i][i]));
            max = Math.max(max, isPrime(nums[i][n - i - 1]));
        }
        return max;
    }

    public static void main(String[] args) {
        ProblemA o = new ProblemA();
        int[][] nums = {{1,2,3,},{5,6,7},{9,10,11}};
        System.out.println(o.diagonalPrime(nums));
    }
}