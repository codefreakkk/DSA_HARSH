package Greedy;

import java.util.*;

public class MinimumCostToCutBoardIntoSquare_CHOCOLA {
    public static int minimumCostToCutABoardIntoSquare(int[] x, int[] y, int n, int m) {
        x = Arrays.stream(x).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
        y = Arrays.stream(y).boxed().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();

        int i = 0, j = 0;
        int ans = 0, vertical = 1, horizontal = 1;
        while (i < x.length && j < y.length) {
            if (x[i] > y[j]) {
                ans += x[i] * vertical;
                horizontal++;
                i++;
            }
            else {
                ans += y[j] * horizontal;
                vertical++;
                j++;
            }
        }
        while (i < x.length) {
            ans += x[i] * vertical;
            i++;
        }

        while (j < y.length) {
            ans += y[j] * horizontal;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] x = {1, 1, 1};
        int[] y = {1, 1, 1};
        System.out.println(minimumCostToCutABoardIntoSquare(x, y, x.length, y.length));
    }
}
