package leetcodeContest.Biweekly105;

import java.util.Arrays;

public class ProblemA {

    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int total = prices[0] + prices[1];
        return money - total >= 0 ? money - total : money;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int money = 3;
        System.out.println(buyChoco(nums, money));
    }
}
