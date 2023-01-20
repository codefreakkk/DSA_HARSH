package trees.BinaryTrees;

import java.util.*;

public class ConstructExpressionTree {
    public BinaryTreeNode constructTree(char[] postfix) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        for (char ch : postfix) {
            if (Character.isAlphabetic(ch))
                stack.push(new BinaryTreeNode(ch));
            else {
                BinaryTreeNode root = new BinaryTreeNode(ch);
                root.right = stack.pop();
                root.left = stack.pop();
                stack.push(root);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {

    }
}
