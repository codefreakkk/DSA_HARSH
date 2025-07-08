package DSA_REVISION.heaps;

public class MinHeap {

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void heapify(int index, int[] nums) {
        int minimum = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int size = nums.length;

        if (leftIndex < size && nums[leftIndex] < nums[index]) {
            minimum = leftIndex;
        }
        if (rightIndex < size && nums[rightIndex] < nums[index]) {
            minimum = rightIndex;
        }

        if (minimum != index) {
            swap(index, minimum, nums);
            heapify(minimum, nums);
        }
    }

    public int[] buildMinHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(i, nums);
        }
        return nums;
    }

}
