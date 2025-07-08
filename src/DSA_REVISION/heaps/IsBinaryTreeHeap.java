package DSA_REVISION.heaps;

import java.util.*;

public class IsBinaryTreeHeap {
    class Node {
        int data;
        Node left, right;
    }

    public boolean checkCompleteTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean end = false;
        while (!queue.isEmpty()) {
            Node element = queue.poll();
            if (element == null) {
                end = true;
            } else {
                if (end) return false;
                queue.offer(element.left);
                queue.offer(element.right);
            }
        }
        return true;
    }

    public boolean checkMaxHeap(Node root, int parent) {
        if (root == null) {
            return true;
        }
        if (parent < root.data) {
            return false;
        }
        boolean left = checkMaxHeap(root.left, root.data);
        boolean right = checkMaxHeap(root.right, root.data);

        return left && right;
    }

    public boolean isHeap(Node root) {
        if (!checkCompleteTree(root)) {
            return false;
        }
        if (!checkMaxHeap(root, Integer.MAX_VALUE)) {
            return false;
        }
        return true;
    }


}
