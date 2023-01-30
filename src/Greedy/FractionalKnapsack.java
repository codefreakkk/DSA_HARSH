package Greedy;
import java.util.*;
public class FractionalKnapsack {
    class Item {
        int value, weight;
    }
    class Cmp implements Comparator<Item> {
        public int compare(Item item1, Item item2) {
            double value1 = item1.value / item1.weight;
            double value2 = item2.value / item2.weight;
            if (value1 < value2) return 1;
            else if (value1 > value2) return -1;
            return 0;
        }
    }

    double fractionalKnapsack(int W, Item[] nums, int n) {
        Arrays.sort(nums, new Cmp());
        int currentWeight = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentWeight + nums[i].weight > W) {
                int remaining = W - currentWeight;
                int unit = nums[i].value / nums[i].weight;
                sum += unit * remaining;
                break;
            }
            sum += nums[i].value;
            currentWeight += nums[i].weight;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
