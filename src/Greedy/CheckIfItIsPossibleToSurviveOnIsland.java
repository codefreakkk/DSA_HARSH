package Greedy;

public class CheckIfItIsPossibleToSurviveOnIsland {
    public int minimumDays(int N, int S, int M) {
        int sunday = S / 7;

        int totalFood = S * M;
        int buyingDays = S - sunday;
        int ans = 0;

        if (totalFood % N == 0)
            ans = totalFood / N;
        else
            ans = totalFood / N + 1;

        if (ans <= buyingDays) return ans;
        return -1;
    }

    public static void main(String[] args) {

    }
}
