package leetcodeContest.Biweekly150;

public class ProblemB {

    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length, sum = 0;

        for (int i = 0; i < n; i++) {
            int left = i - k, right = i + k;
            if (left >= 0 && right < n && nums[i] > nums[left] && nums[i] > nums[right]) {
                sum += nums[i];
            } else if (right < n && nums[i] > nums[right]) {
                sum += nums[right];
            } else if (left >= 0 && nums[i] > nums[left]) {
                sum += nums[left];
            } else if (left < 0 && right >= n) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
