package POTD_LEETCODE;
import java.util.*;

public class GameOfTwoStacks {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int result = 0, count1 = 0, total = 0;

        for (int val : a) {
            if (total + val > maxSum) {
                break;
            }
            total += val;
            count1++;
        }
        result = count1;

        int count2 = 0;
        for (int val : b) {
            total += val;
            count2++;
            while (total > maxSum && count1 > 0) {
                total -= a.get(count1 - 1);
                count1--;
            }
            result = (total <= maxSum) ? Math.max(count1 + count2, result) : result;
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(4, 2, 4, 6, 1);
        List<Integer> list2 = List.of(2, 1, 8, 5);
        System.out.println(twoStacks(10, list1, list2));
    }
}
