package JUST_CODES;

public class Google_HACKATHON_1 {

    public static int findPairs(int[][] nums, int k) {
        int n = nums.length, ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                    int xor1 = nums[i][0] ^ nums[j][0];
                    int xor2 = nums[i][1] ^ nums[j][1];
                    if (xor1 + xor2 == k) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 0}, {1, 2}
        };
        int k = 2;

        System.out.println(findPairs(nums, k));
    }
}
