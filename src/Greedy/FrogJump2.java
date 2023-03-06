package Greedy;

public class FrogJump2 {
    public int maxJump(int[] stones) {
        int n = stones.length, maxi = 0;
        for (int i = 0; i < n; i++) {
            int jump = i + 2;
            if (jump >= n) {
                maxi = Math.max(maxi, Math.abs(stones[i] - stones[n - 1]));
                break;
            }
            maxi = Math.max(maxi, Math.abs(stones[i] - stones[jump]));
        }
        return maxi;
    }

    public static void main(String[] args) {
        FrogJump2 o = new FrogJump2();
        int[] nums = {0, 2, 5, 6, 7};
        System.out.println(o.maxJump(nums));
    }
}
