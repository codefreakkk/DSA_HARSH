package contests.leetcode.Biweekly96;

// problem not solved
public class ProblemB {
    public static int minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int count = 0;

        while (true) {
            int num1 = 0, num2 = 0, index1 = 0, index2 = 0;
            for (int i = 0; i < n; i++) {
                if (nums1[i] - nums2[i] == 0)
                    continue;

                num1 = nums1[i] - nums2[i];
                index1 = i;
                break;
            }
            for (int i = index1 + 1; i < n; i++) {
                if (nums1[i] - nums2[i] == 0 || i == index1)
                    continue;

                num2 = nums1[i] - nums2[i];
                index2 = i;
                break;
            }

            if ((num1 > 0 && num2 > 0) || (num1 < 0 && num2 < 0)) return -1;

            if (num1 == 0 && num2 == 0) return count;

            if (num1 < 0) nums1[index1] += k;
            else nums1[index1] -= k;

            if (num2 < 0) nums1[index2] += k;
            else nums1[index2] -= k;

            count++;
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {15,31,20,3,28,19};
        int[] nums2 = {36,31,14,0,34,1};
        int k = 3;
        System.out.println(minOperations(nums1, nums2, k));
    }
}
