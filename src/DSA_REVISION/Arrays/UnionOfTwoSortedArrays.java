package DSA_REVISION.Arrays;

import java.util.ArrayList;

public class UnionOfTwoSortedArrays {
    private static void solve(int[] a, int[] b, java.util.ArrayList<Integer> ans) {
        int size1 = a.length, size2 = b.length;
        int i = 0, j = 0;

        while (i < size1 && j < size2) {
            if (a[i] < b[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }
                i++;
            }
            else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                    ans.add(b[j]);
                }
                j++;
            }
        }
        while (i < size1) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }
            i++;
        }
        while (j < size2) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
        }
    }
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(a, b, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-7, 8};
        int[] b = {-8, -3, 8};
        ArrayList<Integer> ans = findUnion(a, b);
        System.out.println(ans);
    }
}
