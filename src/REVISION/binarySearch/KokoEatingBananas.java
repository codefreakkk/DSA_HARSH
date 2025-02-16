package REVISION.binarySearch;

public class KokoEatingBananas {

    private int findK(int[] piles, int mid) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / (double) mid);
        }
        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;

        for (int it : piles) {
            max = Math.max(it, max);
        }

        int start = 1, end = max, ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int total = findK(piles, mid);


            if (total <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start= mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
