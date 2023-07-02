package POTD_LEETCODE;
import java.util.*;

public class MaximumNumberOfAchievableTransferRequests {

    private int ans = 0;
    private void solve(int index, int count, int[] map, int[][] requests) {
        if (index == requests.length) {
            for (int i : map) {
                if (i != 0) return;
            }
            ans = Math.max(ans, count);
            return;
        }

        solve(index + 1, count, map, requests);
        map[requests[index][0]]--;
        map[requests[index][1]]++;
        solve(index + 1, count + 1, map, requests);
        // backtrack
        map[requests[index][0]]++;
        map[requests[index][1]]--;
    }

    public int maxmimumRequests(int n, int[][] requests) {
        int[] map = new int[n];
        solve(0, 0, map, requests);
        return ans;
    }


    public static void main(String[] args) {
        MaximumNumberOfAchievableTransferRequests o = new MaximumNumberOfAchievableTransferRequests();
        int[][] edges = {{0, 0}, {1, 1}, {0, 0}, {2, 0}, {2, 2}, {1, 1}, {2, 1}, {0, 1}, {0, 1}};
        int n = 3;
        System.out.println(o.maxmimumRequests(n, edges));
    }
}
