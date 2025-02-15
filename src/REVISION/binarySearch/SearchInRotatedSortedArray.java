package REVISION.binarySearch;

public class SearchInRotatedSortedArray {

    private int binarySearch(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid + 1 < n && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[0] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(0, n - 1, nums, target);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        int left = binarySearch(0, pivot, nums, target);
        if (left != -1) return left;

        int right = binarySearch(pivot + 1, n - 1, nums, target);
        return right;
    }



}
