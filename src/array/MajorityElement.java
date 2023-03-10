package array;

import java.util.*;

public class MajorityElement {
    public static int majorityElementBruteForce(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > size / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public static int majorityElement(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        int element = nums[0];

        for(int i = 0; i < n; i++) {
            if(cnt == 0) element = nums[i];
            if(element == nums[i]) cnt++;
            else cnt--;
        }
        return element;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}