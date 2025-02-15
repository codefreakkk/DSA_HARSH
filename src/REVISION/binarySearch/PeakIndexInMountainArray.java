package REVISION.binarySearch;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int start = 0, end = n - 1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end ) / 2;
            if (mid < n && nums[mid] > nums[mid + 1]) {
                ans = mid;
                end = mid - 1;
            }
            else if (mid < n && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }

}
