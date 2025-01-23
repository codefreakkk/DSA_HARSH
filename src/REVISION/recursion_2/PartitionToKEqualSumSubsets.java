package REVISION.recursion_2;

public class PartitionToKEqualSumSubsets {
    private boolean solve(int index, int sum, int target, int k, int[] nums, int[] visited) {
        if (k == 1) {
            return true;
        }

        if (sum == target) {
            return solve(0, 0, target, k - 1 , nums, visited);
        }

        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 0 && nums[i] + sum <= target) {
                visited[i] = 1;
                boolean ans = solve(i + 1, sum + nums[i], target, k, nums, visited);
                if (ans) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int it : nums) {
            sum += it;
        }

        if (sum % k != 0) {
            return false;
        }

        int[] visited = new int[nums.length];
        return solve(0, 0, sum / k, k, nums, visited);
    }

    public static void main(String[] args) {

    }
}
