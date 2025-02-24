package REVISION.trees_2.BinaryTrees;

import REVISION.trees_2.TreeNode;

import java.util.*;

public class PreOrderIterative {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            ans.add(current.val);
        }
        return ans;
    }

}
