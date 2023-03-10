package trees.BinaryTrees;

import java.util.*;

public class MorrisTraversalInorder {
    public List<Integer> inorderTraversal(BinaryTreeNode node) {
        List<Integer> ans = new ArrayList<>();
        if(node == null) return ans;

        BinaryTreeNode current = node;
        while(current != null) {
            if(current.left == null) {
                ans.add(current.data);
                current = current.right;
            }
            else {
                BinaryTreeNode prev = current.left;
                while(prev.right != null && prev.right != current) prev = prev.right;
                if(prev.right == null) {
                    prev.right = current;
                    current = current.left;
                }
                else {
                    ans.add(current.data);
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
