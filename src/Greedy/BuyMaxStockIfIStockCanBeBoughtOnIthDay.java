package Greedy;

import java.util.*;

public class BuyMaxStockIfIStockCanBeBoughtOnIthDay {
    class Pair implements Comparable<Pair> {
        int price, index;
        public Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }

        public int compareTo(Pair pair) {
            return this.price - pair.price;
        }
    }

    public int buyMaxProducts(int n, int k, int[] price) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(price[i], i + 1));
        }
        Collections.sort(list);

        int stocks = 0;
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            for (int j = pair.index; j > 0; j--) {
                int temp = pair.price * j;
                if (temp <= k) {
                    stocks += j;
                    k -= temp;
                    break;
                }
            }
        }
        return stocks;
    }

    public static void main(String[] args) {

    }
}
