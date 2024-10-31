package DSA_REVISION.Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int n) {
        List<Integer> row, pre = null;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(Integer.valueOf(1));
                }
                else {
                    row.add(pre.get(j - 1));
                    row.add(pre.get(j));
                }
            }
            pre = row;
            ans.add(row);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
