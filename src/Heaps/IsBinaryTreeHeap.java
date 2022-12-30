package Heaps;

import java.util.*;
public class IsBinaryTreeHeap {
    public boolean isCBT(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isNull = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode element = queue.poll();
            if (element == null)
                isNull = true;
            else {
                if (isNull)
                    return false;

                queue.offer(element.left);
                queue.offer(element.right);
            }
        }
        return true;
    }

    public boolean isMaxOrder(BinaryTreeNode root) {
        if (root.left == null && root.right == null)
            return true;

        if (root.right == null)
            return root.data > root.left.data;
        else {
            boolean left = isMaxOrder(root.left);
            boolean right = isMaxOrder(root.right);

            int leftData = root.left.data;
            int rightData = root.right.data;
            int current = root.data;

            return (left && right) && (current > leftData) && (current > rightData);
        }
    }


    public boolean isHeap(BinaryTreeNode root) {
        if (root == null)
            return true;

        return isCBT(root) && isMaxOrder(root);
    }

    public static void main(String[] args) {

    }
}
