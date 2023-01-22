package contests.leetcode.WeeklyContest329;

import java.util.*;

public class ProblemB {
    public static int[][] sortStudents(int[][] score, int k) {
        int n = score.length;
        int m = score[0].length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(score[i][k], i);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(score[i][k]);
        }
        Collections.sort(list);

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            int element = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            for (int j = 0; j < m; j++) {
                if (j == k)
                    ans[i][j] = element;
                else {
                    ans[i][j] = score[map.get(element)][j];
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] nums = {
                {3, 4},
                {5, 6}
        };
        int k = 0;
        int[][] ans = sortStudents(nums, k);
        for (int[] i : ans)
            System.out.println(Arrays.toString(i));
    }
}
