package JUST_CODES;
import java.util.*;

public class MSCI_PROBLEM_2 {
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hund[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thous[] = {"","M","MM","MMM"};

        return thous[num/1000] + hund[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }

    public List<String> roman(int[] nums, int n) {
        List<String> ans = new ArrayList<>();

        for (int i : nums) {
            String romanValue = intToRoman(i);
            ans.add(romanValue);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        MSCI_PROBLEM_2 o = new MSCI_PROBLEM_2();
        System.out.println(o.roman(nums, nums.length));
    }
}
