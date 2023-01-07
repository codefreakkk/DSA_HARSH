package contests.leetcode.Biweekly95;

// not completed
public class ProblemA {
    public static String categorizeBox(int length, int width, int height, int mass) {
        long volume = length * width * height;
        boolean isBulky = false, isHeavy = false;

        if (length >= 10e4 || width >= 10e4 || height >= 10e4 || mass >= 10e4 || volume >= 10e5)
            isBulky = true;

        if (mass >= 100)
            isHeavy = true;

        if (isBulky && isHeavy)
            return "Both";
        else if (isBulky)
            return "Bulky";
        else if (isHeavy)
            return "Heavy";
        else
            return "Neither";
    }
    public static void main(String[] args) {
        int length = 3223, width = 1271, height = 2418, mass = 749;
        System.out.println(categorizeBox(length, width, height, mass));
    }
}
