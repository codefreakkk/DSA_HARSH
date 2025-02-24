package REVISION.trees_2.BinaryTrees;

import REVISION.trees_2.TreeNode;

import java.util.*;

public class PostOrderIterative {

    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            } else {
                ans.add(currentNode.val);
                stack.pop();
                stack.push(currentNode.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
