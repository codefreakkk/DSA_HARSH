package trees.NaryTree;

import java.util.Scanner;

public class MaxDepthOfNaryTree {
    int max = 0;
    public void solve(Node root, int depth) {
        if (root != null) {
            if (root.children.isEmpty()) {
                max = Math.max(max, depth);
            }
        }

        for (Node child : root.children)
            solve(child, depth + 1);
    }

    public int maxDepth(Node root) {
        solve(root, 1);
        return max;
    }

    public static void main(String[] args) {

    }
}
