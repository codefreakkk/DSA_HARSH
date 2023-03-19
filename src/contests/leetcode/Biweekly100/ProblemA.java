package contests.leetcode.Biweekly100;

public class ProblemA {
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        if (money > children * 8) return children - 1;

        int ans = 0;
        while (money > 0 && money - 8 >= children - 1) {
            ans++;
            children--;
            money -= 8;
        }
        if (money == 4 && children == 1) ans--;
        return ans;
    }

    public static void main(String[] args) {

    }
}
