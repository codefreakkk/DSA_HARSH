package POTD_LEETCODE;

public class MinimumDepthOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left, right;

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left, right) + 1;
    }


    public static void main(String[] args) {

    }
}
