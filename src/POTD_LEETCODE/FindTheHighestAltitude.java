package POTD_LEETCODE;

public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int sum = 0, ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(sum, ans);
            sum += gain[i];
        }
        if (sum > ans) return sum;
        return ans;
    }

    public static void main(String[] args) {

    }
}
