package REVISION.trees_2.BinaryTrees;

import REVISION.trees_2.TreeNode;

import java.util.*;

public class PostOrderIterative2 {

    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    ans.add(temp.val);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
