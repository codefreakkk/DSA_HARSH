package POTD_LEETCODE;

public class AddDigits {

    private static int getDigits(int num) {
        int temp = 0;
        while (num > 0) {
            temp += num % 10;
            num /= 10;
        }
        return temp;

    }

    public static int addDigits(int num) {
        int temp = getDigits(num);
        while (temp > 9) {
            temp = getDigits(temp);
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
