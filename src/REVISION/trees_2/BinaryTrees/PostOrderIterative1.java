package REVISION.trees_2.BinaryTrees;

import REVISION.trees_2.TreeNode;

import java.util.*;

public class PostOrderIterative1 {

    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode currentNode = stack1.pop();
            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
            stack2.push(currentNode);
        }

        while (!stack2.isEmpty()) {
            int val = stack2.pop().val;
            ans.add(val);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
