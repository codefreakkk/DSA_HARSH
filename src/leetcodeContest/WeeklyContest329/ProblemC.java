package leetcodeContest.WeeklyContest329;

public class ProblemC {
    public static boolean makeStringEqual(String s, String target) {
        int srcCount = 0, targetCount = 0;
        for (int i = 0; i < s.length(); i++) {
            srcCount += s.charAt(i) - '0';
            targetCount += target.charAt(i) - '0';
        }
        if ((srcCount > 0 && targetCount > 0) || (srcCount == 0 && targetCount == 0))
            return true;

        return false;
    }
    public static void main(String[] args) {
        String s = "11", target = "00";
        System.out.println(makeStringEqual(s, target));
    }
}
