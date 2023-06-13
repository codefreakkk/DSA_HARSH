package POTD_LEETCODE;
import java.util.*;

public class EqualRowAndColumnPairs {

    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String num = Arrays.toString(grid[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = grid[j][i];
            }

            String num = Arrays.toString(temp);
            if (map.containsKey(num)) {
                ans += map.get(num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {3,2,1},{1,7,6},{2,7,7}
        };
        System.out.println(equalPairs(nums));
    }
}
