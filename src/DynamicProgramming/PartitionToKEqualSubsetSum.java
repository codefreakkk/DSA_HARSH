package DynamicProgramming;

public class PartitionToKEqualSubsetSum {

    private boolean solve(int index, long sum, long target, int k, int[] visited, int[] nums) {
        if (index >= nums.length) return false;
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return solve(0, 0, target, k - 1, visited, nums);
        }

        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 1 || sum + nums[i] > target) {
                continue;
            }

            visited[i] = 1;
            boolean ans = solve(i + 1, sum + nums[i], target, k, visited, nums);
            if (ans) return true;
            visited[i] = 0;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        long sum = 0;
        for (int it : nums) sum += it;

        if (sum % k != 0) return false;

        int[] visited = new int[nums.length];
        return solve(0, 0l, sum / k, k, visited, nums);
    }

    public static void main(String[] args) {
        PartitionToKEqualSubsetSum o = new PartitionToKEqualSubsetSum();
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(o.canPartitionKSubsets(nums, k));
    }
}
