package leetcodeContest.Biweekly95;

public class ProblemA {
    public static String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long)length*width*height;
        boolean isBulky = false, isHeavy = false;


        if (length >= 1e4 || width >= 1e4 || height >= 1e4 || mass >= 1e4 || volume >= 1e9)
            isBulky = true;

        if (mass >= 100)
            isHeavy = true;

        if (isBulky && isHeavy)
            return "Both";
        if (isBulky)
            return "Bulky";
        if (isHeavy)
            return "Heavy";

        return "Neither";
    }
    public static void main(String[] args) {
        int length = 3223, width = 1271, height = 2418, mass = 749;
        System.out.println(categorizeBox(length, width, height, mass));
    }
}
