package REVISION.recursion_2;

import java.util.*;

public class CombinationSum3 {


    private void solve(int index, int k, int n, List<Integer> output, List<List<Integer>> ans) {
        if (k == 0) {
            if (n == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            if (n >= i) {
                output.add(i);
                solve(i + 1, k - 1, n - i, output, ans);
                output.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);
        return ans;
    }


    public static void main(String[] args) {

    }
}
