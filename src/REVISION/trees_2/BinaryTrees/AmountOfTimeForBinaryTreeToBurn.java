package REVISION.trees_2.BinaryTrees;

import REVISION.trees_2.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBurn {
    private void markParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                map.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    private TreeNode findStart(TreeNode root, int start) {
        if (root == null) {
            return null;
        }
        if (root.val == start) {
            return root;
        }
        TreeNode left = findStart(root.left, start);
        TreeNode right = findStart(root.right, start);

        if (left == null) {
            return right;
        }
        return left;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);

        TreeNode startNode = findStart(root, start);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(startNode, true);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }

                if (node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }

                TreeNode parentNode = parent.get(node);
                if (parentNode != null && !visited.containsKey(parentNode)) {
                    queue.offer(parentNode);
                    visited.put(parentNode, true);
                }
            }
            ans++;
        }
        return ans - 1;
    }
}
