package trees.BinaryTrees;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndPostorder {
    public int preIndex = 0;
    public BinaryTreeNode solve(int[] preorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if(postStart > postEnd) return null;

        BinaryTreeNode root = new BinaryTreeNode(preorder[preIndex]);
        preIndex++;

        // base condition for leaf node
        if(postStart == postEnd) return root;

        // find child of current root node
        int postIndex = map.get(preorder[preIndex]);
        root.left = solve(preorder, postStart, postIndex, map);
        root.right = solve(preorder, postIndex + 1, postEnd - 1, map);
        return root;
    }
    public BinaryTreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < preorder.length; i++) map.put(postorder[i], i);
        return solve(preorder, 0, postorder.length - 1, map);
    }
    public static void main(String[] args) {

    }
}


