package array;

import java.util.*;

public class KthPermutationSequenceLeetcode60 {
    public static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        k -= 1;
        String answer = "";
        while(true) {
            answer = answer + numbers.get(k / fact);
            numbers.remove(k / fact);
            if(numbers.size() == 0) break;
            k %= fact;
            fact /= numbers.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
