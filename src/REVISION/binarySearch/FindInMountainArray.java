package REVISION.binarySearch;

interface MountainArray {
    int get(int index);
    int length();
}
public class FindInMountainArray {

    public int findPivot(MountainArray nums) {
        int n = nums.length();
        int start = 0, end = n - 1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end ) / 2;
            if (mid < n && nums.get(mid) > nums.get(mid + 1)) {
                ans = mid;
                end = mid - 1;
            }
            else if (mid < n && nums.get(mid) < nums.get(mid + 1)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }

    public int searchLeft(int start, int end, int target, MountainArray nums) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums.get(mid) == target) {
                return mid;
            }
            if (nums.get(start) < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return - 1;
    }

    public int searchRight(int start, int end, int target, MountainArray nums) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums.get(mid) == target) {
                return mid;
            }
            if (nums.get(start) > target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return - 1;
    }

    public int findInMountainArray(int target, MountainArray nums) {
        int n = nums.length();
        int pivot = findPivot(nums);

        int left = searchLeft(0, pivot - 1, target, nums);
        if (left != -1) {
            return left;
        }
        int right = searchRight(pivot, n - 1, target, nums);
        return right;
    }


    public static void main(String[] args) {

    }
}
