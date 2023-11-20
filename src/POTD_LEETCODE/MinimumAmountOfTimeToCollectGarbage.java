package POTD_LEETCODE;
import java.util.*;

public class MinimumAmountOfTimeToCollectGarbage {

    public static int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, ans = 0, count = 0;
        int m = 0, p = 0, g = 0;

        for (int i = 0; i < n; i++) {
            for (char ch : garbage[i].toCharArray()) {
                if (ch == 'M') {
                    m = i;
                }
                if (ch == 'P') {
                    p = i;
                }
                if (ch == 'G') {
                    g = i;
                }
                count++;
            }
        }

        ans = count;

        for (int i = 1; i < n - 1; i++) {
            travel[i] += travel[i - 1];
        }

        if (m != 0) {
            ans += travel[m - 1];
        }
        if (p != 0) {
            ans += travel[p - 1];
        }
        if (g != 0) {
            ans += travel[g - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2, 4, 3};
        System.out.println(garbageCollection(garbage, travel));
    }
}
