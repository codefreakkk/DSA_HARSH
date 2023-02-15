package JUST_CODES;

import java.util.*;

public class AddToArrayFormOfInteger {
    public static List<Integer> addToArrayForm(int[] nums, int k) {
        String val = String.valueOf(k);
        int size1 = nums.length, size2 = val.length(), carry = 0;
        List<Integer> ans = new ArrayList<>();
        int i = size1 - 1, j = size2 - 1;

        int sum = 0;
        while (i >= 0 || j >= 0) {
            sum += carry;
            if (i >= 0) {
                sum += nums[i];
                i--;
            }
            if (j >= 0) {
                sum += val.charAt(j) - '0';
                j--;
            }
            if (sum > 9) {
                carry = sum / 10;
                ans.add(sum % 10);
            }
            else {
                ans.add(sum);
                carry = 0;
            }
            sum = 0;
        }
        if (carry != 0) ans.add(carry);
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
        int k = 516;
        System.out.println(addToArrayForm(nums, k));
    }
}
