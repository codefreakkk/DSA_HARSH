package Greedy;

import java.util.*;

public class DefenseOfAKingdom {
    public static void defkin() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int n = sc.nextInt();

            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();

            x.add(0);
            y.add(0);

            for (int i = 0; i < n; i++) {
                int val1 = sc.nextInt();
                x.add(val1);

                int val2 = sc.nextInt();
                y.add(val2);
            }
            x.add(w + 1);
            y.add(h + 1);

            Collections.sort(x);
            Collections.sort(y);

            int mx = 0, my = 0;
            for (int i = 0; i < x.size() - 1; i++) {
                mx = Math.max(mx, x.get(i + 1) - x.get(i) - 1);
                my = Math.max(my, y.get(i + 1) - y.get(i) - 1);
            }
            System.out.println(mx * my);
        }
    }
    public static void main(String[] args) {
        defkin();
    }
}
