package Maths;

import java.util.*;

public class PrimeFactorOfANumber {
    public static List<Integer> primeFactorOfNumber(int num) {
        int divisor = 2;
        List<Integer> list = new ArrayList<>();

        while (num > 1) {
            if (num % divisor == 0) {
                list.add(divisor);
                num /= divisor;
            }
            else
                divisor++;
        }
        return list;
    }
    public static void main(String[] args) {
        int num = 10;
        List<Integer> ans = primeFactorOfNumber(num);
        System.out.println(ans);
    }
}
