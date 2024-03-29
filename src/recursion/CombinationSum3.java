package recursion;

import java.util.*;

public class CombinationSum3 {
    public static void solve(int k, int n, int index, int sum, int element, List<Integer> output, List<List<Integer>> answer) {
        if(sum > n) return;
        if(k == 0) {
            if(sum == n) {
                answer.add(new ArrayList<>(output));
            }
            return;
        }
        if(index == 10) return;
        output.add(index);
        sum += index;
        solve(k - 1, n, index + 1, sum , element + 1, output, answer);
        output.remove(output.size() - 1);
        sum -= index;
        solve(k, n, index + 1, sum, element, output, answer);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(k, n, 1, 0, 0, output, answer);
        return answer;
    }

    public static void main(String args[]) {
        List<List<Integer>> answer = combinationSum3(2, 3);
        for(List<Integer> i : answer) {
            System.out.println(i);
        }
    }
}