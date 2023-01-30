package Greedy;

import java.util.*;
public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize <= 0) break;
            ans += Math.min(truckSize, boxTypes[i][0]) * boxTypes[i][1];
            truckSize -= boxTypes[i][0];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumUnitsOnTruck o = new MaximumUnitsOnTruck();
        int[][] box = {
                {5, 10},{2, 5},{4, 7},{3, 9}
        };
        System.out.println(o.maximumUnits(box, 10));
    }
}
