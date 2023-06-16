package POTD_LEETCODE;
import java.util.*;

public class NumberOfWaysToReorderArrayToGetSameBST {

    private List<List<Integer>> table = new ArrayList<>();

    private void combination(int n) {
        List<Integer> pre = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            table.add(row);
        }
    }

    private int solve(List<Integer> list) {
        if (list.size() <= 2) return 1;
        int n = list.size();

        int root = list.get(0);
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (root > list.get(i)) {
                left.add(list.get(i));
            }
            else right.add(list.get(i));
        }

        int leftAns = solve(left);
        int rightAns = solve(right);
        int leftSize = left.size();

        return table.get(n - 1).get(leftSize) * leftAns * rightAns;
    }

    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int val : nums) list.add(val);

        combination(nums.length);

        return solve(list) - 1;
    }

    public static void main(String[] args) {

    }
}
