package Greedy;

import java.util.*;

public class JobSequencingProblem {
    class Job {
        int id, profit, deadline;
    }

    public int[] jobSequencing(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int max = -1;
        for (int i = 0; i < n; i++) max = Math.max(max, arr[i].deadline);

        int[] deadline = new int[max + 1];
        for (int i = 0; i < max + 1; i++)
            deadline[i] = -1;

        int ans = 0, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (deadline[j] == -1) {
                    deadline[j] = arr[i].id;
                    count++;
                    ans += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{count, ans};
    }

    public static void main(String[] args) {

    }
}
