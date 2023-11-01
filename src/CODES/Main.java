package CODES;
/* Save this in a file called Main.java to compile and test it */

import java.util.*;
import java.io.*;

public class Main {
    public static int processArray(ArrayList<Integer> array, ArrayList<Integer> ans) {
        int i = 0;


        while (i < array.size()) {
            int start = i;
            while (i < array.size() && array.get(i) >= 100 && array.get(i) <= 999) {
                i++;
            }

            int end = i - 1;

            if (end - start >= 1) {
                int max = array.get(start);
                for (int j = start + 1; j <= end; j++) {
                    max = Math.max(max, array.get(j));
                }
                ans.add(max);
                i--;
            } else {
                ans.add(array.get(start));
            }
            i++;
        }

        return ans.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0) {
                break;
            }
            arrayList.add(num);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int new_length = processArray(arrayList, ans);
        for(int i=0; i<new_length; i++)
            System.out.println(ans.get(i));
    }
}
