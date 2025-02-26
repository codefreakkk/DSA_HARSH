package REVISION.recursion_2;

import java.util.*;

public class FindWinnerOfCircularGame {

    private int solve(int index, int k, List<Integer> peoples) {
        if (peoples.size() == 1) {
            return peoples.get(0);
        }
        index = (index + k) % peoples.size();
        peoples.remove(index);
        return solve(index, k, peoples);
    }

    public int findWinner(int n, int k) {
        List<Integer> peoples = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            peoples.add(i);
        }
        return solve(0, k - 1, peoples);
    }


    public static void main(String[] args) {

    }
}
