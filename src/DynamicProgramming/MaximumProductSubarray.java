package DynamicProgramming;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;

        int preffix = 1, suffix = 1, ans = 0;
        for (int i = 0; i < n; i++) {
            preffix *= nums[i];
            suffix *= nums[n - i - 1];
            ans = Math.max(ans, Math.max(preffix, suffix));
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
