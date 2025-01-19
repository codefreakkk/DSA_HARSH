package REVISION.recursion_2;

import recursion.Dice;

public class DiceThrow {

    public static int solve(int n, int k, int target) {
        int MOD = (int) 1e9 + 7;
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0 || target < 0) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            count += solve(n - 1, k, target - i) % MOD;
        }
        return count % MOD;
    }

    public static int numRollsToTarget(int n, int k, int target) {
        return solve(n, k, target);
    }

    public static void main(String[] args) {
        System.out.println(DiceThrow.solve(2, 6, 7));
    }
}
