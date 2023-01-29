package Greedy;

import java.util.*;

public class ShopInCandyStore {
    public ArrayList<Integer> candyStore(int[] candy, int n, int k) {
        Arrays.sort(candy);
        int buy = n - k, min = 0, max = 0;

        for (int i = 0; i < buy; i++) min += candy[i];
        for (int i = n - 1; i >= buy; i--) max += candy[i];

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);
        return ans;
    }

    public static void main(String[] args) {

    }
}
