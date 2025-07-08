package DSA_REVISION.heaps;

public class HeapSort {

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void heapify(int index, int size, int[] nums) {
        int maximum = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < size && nums[leftIndex] > nums[maximum]) {
            maximum = leftIndex;
        }
        if (rightIndex < size && nums[rightIndex] > nums[maximum]) {
            maximum = rightIndex;
        }

        if (maximum != index) {
            swap(index, maximum, nums);
            heapify(maximum, size, nums);
        }
    }

    public void heapSort(int[] nums) {
        int n = nums.length;

        for (int i = n / 2; i >= 0; i--) {
            heapify(i, n, nums);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(0, i, nums);
            heapify(0, i, nums);
        }
    }

}
