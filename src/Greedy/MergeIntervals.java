package Greedy;

import java.util.*;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] interval) {
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);
        int value1 = interval[0][0];
        int value2 = interval[0][1];
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < interval.length; i++) {
            if (value2 >= interval[i][0]) {
                value1 = Math.min(interval[i][0], value1);
                value2 = Math.max(interval[i][1], value2);
            }
            else {
                list.add(new int[]{value1, value2});
                value1 = interval[i][0];
                value2 = interval[i][1];
            }
        }
        list.add(new int[]{value1, value2});
        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }

    public static void main(String[] args) {
        int[][] interval = {
                {1, 4},{0,0}
        };
        int[][] ans = mergeIntervals(interval);
        for (int[] i : ans) System.out.println(Arrays.toString(i));
    }
}
