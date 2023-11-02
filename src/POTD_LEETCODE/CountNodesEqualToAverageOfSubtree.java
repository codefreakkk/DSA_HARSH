package POTD_LEETCODE;

public class CountNodesEqualToAverageOfSubtree {

    class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Pair {
        int size , val;
        public Pair(int size, int val) {
            this.size = size;
            this.val = val;
        }
    }

    private int ans = 0;

    private Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int totalSize = left.size + right.size + 1;
        int totalVal = left.val + right.val + root.val;
        if (root.val == (totalVal / totalSize)) {
            ans++;
        }
        return new Pair(totalSize, totalVal);
    }

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

    public static void main(String[] args) {

    }
}
