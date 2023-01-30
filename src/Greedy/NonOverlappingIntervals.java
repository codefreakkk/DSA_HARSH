package Greedy;

import java.util.*;

public class NonOverlappingIntervals {
    class Cmp implements Comparator<int[]> {
        public int compare(int[] arr1, int[] arr2) {
            return arr1[1] - arr2[1];
        }
    }

    public int eraseOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Cmp());
        int count = 0, endTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= endTime)
                endTime = intervals[i][1];

            else count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},{2, 3}
        };
        NonOverlappingIntervals o = new NonOverlappingIntervals();
        System.out.println(o.eraseOverlappingIntervals(arr));
    }
}
