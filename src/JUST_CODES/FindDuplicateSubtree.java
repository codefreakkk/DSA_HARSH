package JUST_CODES;
import java.util.*;
public class FindDuplicateSubtree {
    class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private String solve(TreeNode root, HashMap<String, Integer> map, List<TreeNode> ans) {
        if (root == null) return "";

        String left = solve(root.left, map, ans);
        String right = solve(root.right, map, ans);

        int currentVal = root.val;
        String data = currentVal + "$" + left + "$" + right;
        if (map.getOrDefault(data, 0) == 1) {
            ans.add(root);
        }
        map.put(data, map.getOrDefault(data, 0) + 1);
        return data;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        solve(root, map, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
