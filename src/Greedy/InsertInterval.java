package Greedy;

import java.util.*;

public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0])
                list.add(interval);

            else if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval;
            }
            else if (interval[1] >= newInterval[0]) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        list.add(newInterval);
        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }

    // approach 2nd (GFG APPROACH)
    public static int[][] insertNewEvent(int n,int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        list.add(newInterval);

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++)
            ans[j] = list.get(j);

        return ans;
    }

    public static void main(String[] args) {
        int[][] interval = {
                {1, 3},{6, 9}
        };
        int[] newInterval = {2, 5};
        int[][] ans = insertInterval(interval, newInterval);
        for (int[] i : ans) System.out.println(Arrays.toString(i));
    }
}
