package REVISION.trees_2.BinaryTrees;

import REVISION.trees_2.TreeNode;

public class CountCompleteTreeNodes {

    private int findLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    private int findRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.right;
            count++;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findLeftHeight(root.left);
        int right = findRightHeight(root.right);

        if (left == right) {
            return (2 << (left))- 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

    }

}
