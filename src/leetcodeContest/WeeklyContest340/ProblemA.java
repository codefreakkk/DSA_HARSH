package leetcodeContest.WeeklyContest340;

public class ProblemA {

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                max = Math.max(max, nums[i][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[n - i - 1][i])) {
                max = Math.max(max, nums[n - i - 1][i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ProblemA o = new ProblemA();
        int[][] nums = {{1,2,3,},{5,6,7},{9,10,11}};
        System.out.println(o.diagonalPrime(nums));
    }
}