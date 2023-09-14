package RANDOM_PROBLEM;
import java.util.*;

public class MasterCard_1 {

    class TreeNode {
        TreeNode left, right;
        int value;
        public TreeNode(int value) {
            this.value = value;
        }
    }


    private void constructTree(TreeNode current, String directions, int nodeValue) {
        int n = directions.length();

        for (int i = 0; i < n - 1; i++) {
            if (directions.charAt(i) == 'L') {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        if (directions.charAt(n - 1) == 'L') {
            current.left = new TreeNode(nodeValue);
        }
        else {
            current.right = new TreeNode(nodeValue);
        }
    }

    private TreeNode findPath(TreeNode root, int leftNode, int rightNode, List<Integer> ans) {
        return null;
    }

    public List<Integer> findShortestPath(String[] queries, int rootNode, int leftNode, int rightNode) {
        TreeNode root = new TreeNode(rootNode);

        // construct tree
        for (String s : queries) {
            String[] split = s.split(" ");

            String directions = split[0];
            int nodeValue = Integer.parseInt(split[1]);

            TreeNode current = root;
            constructTree(current, directions, nodeValue);
        }

        // find path
        List<Integer> ans = new ArrayList<>();
        findPath(root, leftNode, rightNode, ans);
        return ans;
    }

    public static void main(String[] args) {
        MasterCard_1 o = new MasterCard_1();
        String[] s = {
                "L 23", "R 44", "LL 13", "LR 9", "RL 4", "RR 7", "RLL 6", "RLR 18"
        };
        System.out.println(o.findShortestPath(s, 11, 13, 18));
    }
}
