package REVISION.trees_1.BinaryTrees;

import java.util.*;

public class BoundaryTraversalOfBinaryTree {
    public boolean isLeaf(BinaryTreeNode node) {
        return node.left == null && node.right == null;
    }
    public void leftNodes(BinaryTreeNode node, ArrayList<Integer> ans) {
        BinaryTreeNode current = node.left;
        while(current != null) {
            if(!isLeaf(current)) ans.add(current.data);
            if(current.left != null) current = current.left;
            else current = current.right;
        }
    }

    public void leafNodes(BinaryTreeNode node, ArrayList<Integer> ans) {
        if(isLeaf(node)) {
            ans.add(node.data);
            return;
        }

        if(node.left != null) leafNodes(node.left, ans);
        if(node.right != null) leafNodes(node.right, ans);
    }

    public void rightNodes(BinaryTreeNode node, ArrayList<Integer> ans) {
        BinaryTreeNode current = node.right;
        ArrayList<Integer> output = new ArrayList<>();

        while(current != null) {
            if(!isLeaf(current)) output.add(current.data);
            if(current.right != null) current = current.right;
            else current = current.left;
        }

        // reverse output
        Collections.reverse(output);
        for(int i = 0; i < output.size(); i++) ans.add(output.get(i));
    }

    public ArrayList<Integer> boundaryTraversal(BinaryTreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        if(!isLeaf(node)) ans.add(node.data);

        leftNodes(node, ans);
        leafNodes(node, ans);
        rightNodes(node, ans);

        return ans;
    }


    public static void main(String[] args) {

    }
}
