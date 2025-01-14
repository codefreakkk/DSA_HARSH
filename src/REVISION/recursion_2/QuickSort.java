package REVISION.recursion_2;

import java.util.Arrays;

public class QuickSort {

    public int partition(int start, int end, int[] nums) {
        int pivot = nums[start];
        int count = 0;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= pivot) {
                count++;
            }
        }

        int pivotIndex = start + count;
        int temp = nums[start];
        nums[start] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        // place elements according to pivot
        int i = start, j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while (nums[i] <= nums[pivotIndex]) i++;
            while (nums[j] > nums[pivotIndex]) j--;

            if (i < pivotIndex && j > pivotIndex) {
                int tempVar = nums[i];
                nums[i] = nums[j];
                nums[j] = tempVar;
            }
        }
        return pivotIndex;
    }

    public void quickSort(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int pivot = partition(start, end, nums);
        quickSort(start, pivot - 1, nums);
        quickSort(pivot + 1, end, nums);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {2, 4, 2, 34, 2 ,4 , 3, 1};
        quickSort.quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }
}
