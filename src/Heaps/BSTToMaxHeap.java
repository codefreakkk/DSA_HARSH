package Heaps;

import java.util.*;

public class BSTToMaxHeap {
    public static void inorder(BinaryTreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void postorder(BinaryTreeNode root, List<Integer> list, int[] index) {
        if (root == null)
            return;

        postorder(root.left, list, index);
        postorder(root.right, list, index);
        root.data = list.get(index[0]++);
    }

    public static void convertToMaxHeap(BinaryTreeNode root) {
        if (root == null)
            return;

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        postorder(root, list, new int[]{0});
    }

    public static void main(String[] args) {

    }
}
