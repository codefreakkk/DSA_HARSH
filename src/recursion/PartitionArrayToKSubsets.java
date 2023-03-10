package recursion;

public class PartitionArrayToKSubsets {
//    gfg problem
//    https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1
    public static boolean solve(int[] arr, int n, int k, int count, int currentSum, int sum, int[] visited) {
        if(count == k - 1) return true;
        if(currentSum > sum) return false;
        if(currentSum == sum) {
            if(solve(arr, n, k, count + 1, 0, sum, visited)) {
                return true;
            }
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                if(solve(arr, n, k, count, currentSum + arr[i], sum, visited)) {
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }

    public static boolean isKPartitionPossible(int[] arr, int n, int k) {
        if(k == 1) return true;
        if(k > n) return false;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum % k != 0) return false;
        int[] visited = new int[n];
        return solve(arr, n, k, 0, 0, sum / k, visited);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(isKPartitionPossible(nums, nums.length, 3));
    }
}