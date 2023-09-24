package POTD_LEETCODE;
import java.util.*;

public class ChampagneTower {

    public static double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) {
            return 0;
        }

        List<Double> row = new ArrayList<>();
        row.add((double)poured);

        for (int i = 0; i < query_row; i++) {
            List<Double> next = new ArrayList<>();
            for (int it = 0; it < i + 2; it++) {
                next.add(0.0);
            }

            for (int j = 0; j <= i; j++) {
                if (row.get(j) <= 1) {
                    continue;
                }
                double value = ((row.get(j) - 1) / 2.0);
                next.set(j, next.get(j) + value);
                next.set(j + 1, next.get(j + 1) + value);
            }
            row = next;
        }
        return row.get(query_glass);
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(1, 1, 1));
    }
}














