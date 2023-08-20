package leetcodeContest.WeeklyContest359;
import java.util.*;

public class ProblemA {

    public boolean isAcronym(List<String> words, String s) {
        String str = "";
        for (String word : words) {
            char initial = word.charAt(0);
            str += initial;
        }
        return str.equals(s);
    }

    public static void main(String[] args) {

    }
}
