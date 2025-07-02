package DSA_REVISION.Graph;

import java.util.*;

public class MostStonesRemoved {

    public int removeStones(int[][] stones) {
        int row = 0, col = 0, n = stones.length;
        for (int[] stone : stones) {
            row = Math.max(row, stone[0]);
            col = Math.max(col, stone[1]);
        }

        DisjointSet ds = new DisjointSet(row + col + 1);
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            int newRow = stone[0];
            int newCol = stone[1] + row + 1;
            ds.unionBySize(newRow, newCol);
            set.add(newRow);
            set.add(newCol);
        }

        int count = 0;
        for (int num : set) {
            if (ds.findParent(num) == num) {
                count++;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {

    }
}
