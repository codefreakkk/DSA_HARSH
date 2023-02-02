package Greedy;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {five--; ten--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {5,5,5,10,20};
        System.out.println(lemonadeChange(nums));
    }
}
