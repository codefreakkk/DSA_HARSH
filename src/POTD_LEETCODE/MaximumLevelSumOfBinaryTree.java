package POTD_LEETCODE;
import java.util.*;

public class MaximumLevelSumOfBinaryTree {

    class TreeNode {
        TreeNode left, right;
        int val;
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE, level = 0, ans = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode element = queue.poll();
                sum += element.val;

                if (element.left != null) {
                    queue.offer(element.left);
                }
                if (element.right != null) {
                    queue.offer(element.right);
                }
            }
            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
