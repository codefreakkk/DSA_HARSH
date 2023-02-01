package Greedy;

import java.util.*;
public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, count = 0;
        for (int j = 0; j < s.length && i < g.length; j++) {
            if (g[i] <= s[j]) {
                count++;
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
}
