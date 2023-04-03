package JUST_CODES;
import java.util.*;

public class SuccessfullPairsOfSpellsAndPotions {

    private int findPairs(int[] nums, long target, int val) {
        int n = nums.length;
        int low = 0, high = n - 1, index = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long product = nums[mid] * (val * 1l);

            if (product >= target) {
                index = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return n - index;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < spells.length; i++) {
            int index = findPairs(potions, success, spells[i]);
            list.add(index);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }

    public static void main(String[] args) {

    }
}
