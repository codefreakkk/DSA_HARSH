package Greedy;

public class Candy {
    public static int candy(int[] rating) {
        int size = rating.length;
        int[] candy = new int[size];

        for (int i = 0; i < size; i++)
            candy[i] = 1;

        for (int i = 1; i < size; i++) {
            if (rating[i] > rating[i - 1])
                candy[i] = candy[i - 1] + 1;
        }

        int totalCandies = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (i != size -1 && rating[i] > rating[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i +1] + 1);
            }
            totalCandies += candy[i];
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }
}
