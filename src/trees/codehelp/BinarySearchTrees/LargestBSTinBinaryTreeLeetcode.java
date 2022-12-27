package trees.codehelp.BinarySearchTrees;

class Tupples {
    int size, max, min;

    public Tupples(int max, int min, int size) {
        this.max = max;
        this.min = min;
        this.size = size;
    }
}

public class LargestBSTinBinaryTreeLeetcode {

    public Tupples solve(TreeNode root, int[] result) {
        if (root == null) {
            return new Tupples(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Tupples left = solve(root.left, result);
        Tupples right = solve(root.right, result);

        if (left.max < root.data && root.data < right.min) {
            int sum = left.size + right.size + root.data;
            result[0] = Math.max(result[0], sum);
            return new Tupples(Math.max(root.data, right.max), Math.min(root.data, left.min), sum);
        }
        return new Tupples(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        int[] result = {0};
        solve(root, result);
        return result[0];
    }
    
    public static void main(String[] args) {

    }
}
