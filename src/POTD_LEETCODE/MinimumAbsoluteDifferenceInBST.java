package POTD_LEETCODE;
import java.util.*;

public class MinimumAbsoluteDifferenceInBST {

    class TreeNode {
        int val;
        TreeNode left, right;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public int getMinimumDifference(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        inorder(node, list);
        Collections.sort(list);
        return list.get(1) - list.get(0);
    }

    public static void main(String[] args) {

    }
}
