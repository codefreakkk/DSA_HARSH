package POTD_LEETCODE;
import java.util.*;

public class AllPossibleFullBinaryTree {

    class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> allPossibleBF(int n) {
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n; i+=2) {
            List<TreeNode> leftList = allPossibleBF(i);
            List<TreeNode> rightList = allPossibleBF(n - i - 1);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
