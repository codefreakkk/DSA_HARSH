package CODES;

public class CountGoodNodesInBinaryTree {

    class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int solve(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val >= max) {
            count++;
            max = root.val;
        }

        int left = solve(root.left, max);
        int right = solve(root.right, max);
        return left + right + count;
    }

    public int goodNodes(TreeNode root) {
        return solve(root, root.val);
    }

    public static void main(String[] args) {

    }
}
