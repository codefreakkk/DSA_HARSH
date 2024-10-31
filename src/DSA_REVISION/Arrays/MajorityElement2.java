package DSA_REVISION.Arrays;

import java.util.*;

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0, element1 = 0, element2 = 0;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != element2) {
                count1++;
                element1 = nums[i];
            }
            else if (count2 == 0 && nums[i] != element1) {
                count2++;
                element2 = nums[i];
            }
            else if (nums[i] == element1) {
                count1++;
            }
            else if (nums[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == element1) {
                count1++;
            }
            if (num == element2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int mini = (n/3) + 1;
        if (count1 > mini) {
            ans.add(Integer.valueOf(element1));
        }
        if (count2 > mini) {
            ans.add(Integer.valueOf(element2));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
