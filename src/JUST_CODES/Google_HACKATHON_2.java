package JUST_CODES;

import java.util.Arrays;

public class Google_HACKATHON_2 {

    private static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return high;
    }

    public static void printQuery(int[][] grid, int[] query) {
        int n = grid.length;
        int[] nums = new int[n + n - 1];

        int i = 0;
        while (i < n) {
            nums[i] = grid[i][0];
            i++;
        }

        int index = 0;
        i = n - 1;
        while (index < n) {
            nums[i++] = grid[n - 1][index++];
        }

        for (int num : query) {
            System.out.println(lowerBound(nums, num) + 1);
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 6}, {2, 5, 8}, {4, 7, 9}};
        int[] q = {1,4, 6};
        printQuery(nums, q);
    }
}
