package REVISION.recursion_2;

import java.util.Arrays;

public class MergeSort {

    public void merge(int start, int end, int mid, int[] nums) {
        int[] temp = new int[(end - start) + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }

        for (int index1 = 0, index2 = start; index1 < temp.length; index1++, index2++) {
            nums[index2] = temp[index1];
        }
    }

    public void mergeSort(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(start, mid, nums);
        mergeSort(mid + 1, end, nums);
        merge(start, end, mid, nums);
    }

    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        int[] nums = {2, 3, 1, 43, 5, 7, 2, 1};
        obj.mergeSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }
}
