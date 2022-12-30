package Heaps;

import java.util.Arrays;

public class MergeTwoBinaryMaxHeaps {
    public void swap(int[] nums, int parent, int child) {
        int temp = nums[parent];
        nums[parent] = nums[child];
        nums[child] = temp;
    }

    public void heapify(int[] nums, int size, int index) {
        int largest = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && nums[largest] < nums[leftIndex])
            largest = leftIndex;

        if (rightIndex < size && nums[largest] < nums[rightIndex])
            largest = rightIndex;

        if (largest != index) {
            swap(nums, index, largest);
            heapify(nums, size, largest);
        }
    }

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int mergedSize = n + m;
        int[] nums = new int[mergedSize];

        for (int i = 0; i < n; i++)
            nums[i] = a[i];
        for (int i = n, j = 0; i < mergedSize; i++, j++)
            nums[i] = b[j];

        // build heap
        for (int i = mergedSize / 2 - 1; i >= 0; i--)
            heapify(nums, mergedSize, i);

        return nums;
    }

    public static void main(String[] args) {
        MergeTwoBinaryMaxHeaps obj = new MergeTwoBinaryMaxHeaps();
        int[] a = {6, 5, 4};
        int[] b = {12, 7, 2};
        int[] ans = obj.mergeHeaps(a, b, a.length, b.length);
        System.out.println(Arrays.toString(ans));
    }
}
