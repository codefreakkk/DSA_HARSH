package Greedy;

import java.util.*;

public class HuffmanCoding {
    class TreeNode implements Comparable<TreeNode> {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public int compareTo(TreeNode node) {
            if (this.data == node.data) return 1;
            return this.data - node.data;
        }
    }

    private void preorder(TreeNode root, String temp, ArrayList<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(new String(temp));
            return;
        }
        preorder(root.left, temp + '0', ans);
        preorder(root.right, temp + '1', ans);
    }

    public ArrayList<String> huffmanCodes(String s, int f[], int n)
    {
        PriorityQueue<TreeNode> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(f[i]);
            pq.offer(node);
        }

        while (pq.size() > 1) {
            TreeNode left = pq.poll();
            TreeNode right = pq.poll();

            TreeNode root = new TreeNode(left.data + right.data);
            root.left = left;
            root.right = right;
            pq.offer(root);
        }

        ArrayList<String> ans = new ArrayList<>();
        TreeNode root = pq.poll();
        String temp = "";
        preorder(root, temp, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
