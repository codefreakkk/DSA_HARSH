package DynamicProgramming;
import java.util.*;
public class RangeSumQuery {

    List<List<Integer>> list;
    public RangeSumQuery(int[][] matrix) {
        this.list = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(matrix[i][0]);

            for (int j = 1; j < m; j++) {
                int prefix = temp.get(j - 1) + matrix[i][j];
                temp.add(prefix);
            }
            list.add(temp);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0, minus = 0;

        for (int i = row1; i <= row2; i++) {
            sum += list.get(i).get(col2);
            if (col1 > 0) {
                minus += list.get(i).get(col1 - 1);
            }
        }
        return sum - minus;
    }

    public static void main(String[] args) {

    }
}
