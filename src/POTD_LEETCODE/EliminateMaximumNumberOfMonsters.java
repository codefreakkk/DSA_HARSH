package POTD_LEETCODE;
import java.util.*;

public class EliminateMaximumNumberOfMonsters {

    public int eliminateMaximumNumberOfMonsters(int[] dist, int[] speed) {
        int n = dist.length;
        double[] totalTime = new double[n];

        for (int i = 0; i < n; i++) {
            totalTime[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(totalTime);

        int ans = 0, time = 0;
        for (int i = 0; i < n; i++) {
            if (time < totalTime[i]) {
                ans++;
            }
            else break;
            time++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
