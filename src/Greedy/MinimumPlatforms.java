package Greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform = 0, ans = Integer.MIN_VALUE;
        int i = 0, j = 0;

        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            }
            else {
                platform--;
                j++;
            }
            ans = Math.max(platform, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {900, 1100, 1235};
        int[] dep = {1000, 1200, 1240};
        int n = arr.length;
        System.out.println(findPlatform(arr, dep, n));
    }
}
