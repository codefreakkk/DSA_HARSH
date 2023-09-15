package COMPANY_PROBLEMS;

public class Leetcode_1339 {

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private long ans = 0;

    private int getTotalValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTotalValue(root.left);
        int right = getTotalValue(root.right);
        return left + right + root.val;
    }

    private int solve(TreeNode root, int total) {
        if (root == null) {
            return 0;
        }

        int left = solve(root.left, total);
        int right = solve(root.right, total);

        int val1 = left + right + root.val;
        int val2 = total - val1;
        ans = Math.max((long) val1 * val2, ans);

        return val1;
    }

    public int maxProduct(TreeNode root) {
        int total = getTotalValue(root);
        solve(root, total);
        int MOD = (int) 1e9+7;
        return (int) ans % MOD;
    }


    public static void main(String[] args) {

    }
}
