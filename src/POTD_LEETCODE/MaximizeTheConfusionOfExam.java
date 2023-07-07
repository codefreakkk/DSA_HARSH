package POTD_LEETCODE;

public class MaximizeTheConfusionOfExam {

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int trueCount = 0, falseCount = 0, i = 0, j = 0;

        int ans = 0;
        while (j < answerKey.length()) {
            if (answerKey.charAt(j) == 'T') {
                trueCount++;
            }
            else falseCount++;

            while (Math.min(trueCount, falseCount) > k) {
                if (answerKey.charAt(i) == 'T') {
                    trueCount--;
                }
                else falseCount--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "TFFT";
        int k = 1;
        System.out.println(maxConsecutiveAnswers(s, k));
    }
}
