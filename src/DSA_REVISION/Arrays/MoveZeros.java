package DSA_REVISION.Arrays;

import sorting.QuickSort;

public class MoveZeros {

    private void swap(int[] nums, int index1, int index2) {
        QuickSort.swap(nums, index1, index2);
    }

    public void moveZeros(int[] nums) {
        int size = nums.length, zeroCount = 0;

        for (int i = 0; i < size; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            else {
                int index = i - zeroCount;
                swap(nums, index, i);
            }
        }
    }



    public static void main(String[] args) {

    }
}
