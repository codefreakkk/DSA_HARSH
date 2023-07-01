package POTD_LEETCODE;

public class FairDistributionOfCookies {

    private int ans = Integer.MAX_VALUE;

    private void solve(int index, int[] count, int[] cookies, int k) {
        if (index >= cookies.length) {
            int max = 0;
            for (int i : count) {
                max = Math.max(max, i);
            }
            ans = Math.min(ans, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            count[i] += cookies[index];
            solve(index + 1, count, cookies, k);
            count[i] -= cookies[index];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] count = new int[k];

        solve(0, count, cookies, k);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {8,15,10,20,8};
        int k = 2;
        FairDistributionOfCookies o = new FairDistributionOfCookies();
        System.out.println(o.distributeCookies(nums, k));
    }
}
