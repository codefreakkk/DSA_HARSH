package COMPANY_PROBLEMS;

public class FlipStringToMonotoneIncreasing {

    public int minFlips(String s) {
        int oneCount = 0, flipCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') oneCount++;
            else {
                flipCount++;
                flipCount = Math.min(oneCount, flipCount);
            }
        }
        return flipCount;
    }

    public static void main(String[] args) {}
}
