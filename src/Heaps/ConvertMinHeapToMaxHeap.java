package Heaps;

import java.util.Arrays;

public class ConvertMinHeapToMaxHeap {
    public static void swap(int[] nums, int largest, int index) {
        int temp = nums[largest];
        nums[largest] = nums[index];
        nums[index] = temp;
    }

    public static void heapify(int[] nums, int index, int n) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < n && nums[left] > nums[largest])
            largest = left;

        if (right < n && nums[right] > nums[largest])
            largest = right;

        if (largest != index) {
            swap(nums, largest, index);
            heapify(nums, largest, n);
        }
    }

    public static void minHeapToMaxHeap(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, i, n);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        minHeapToMaxHeap(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
