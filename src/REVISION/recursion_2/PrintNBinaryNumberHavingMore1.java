package REVISION.recursion_2;
import java.util.*;

public class PrintNBinaryNumberHavingMore1 {
    private void solve(int one, int zero, String output,  int n, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(output);
            return;
        }
        solve(one + 1, zero, output + "1", n - 1, ans);
        if (one > zero) {
            solve(one, zero + 1, output + "0", n - 1, ans);
        }
    }

    public ArrayList<String> nBitBinaryNumber(int n) {
        ArrayList<String> ans = new ArrayList<>();
        solve(0, 0, "", n, ans);
        return ans;
    }

}
