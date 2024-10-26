package DSA_REVISION.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int prev = 0, k = 0, index = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[prev]) {
                k++;
                nums[k] = nums[i];
            }
            prev = i;
        }
        return k + 1;

    }

    public static void main(String[] args) {

    }
}
