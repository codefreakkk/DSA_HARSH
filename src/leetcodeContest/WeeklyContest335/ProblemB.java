package leetcodeContest.WeeklyContest335;
import java.util.*;
public class ProblemB {
    class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
            this.left= null;
            this.right = null;
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        list.add((long)root.val);

        while (!queue.isEmpty()) {
            int level = queue.size();
            long sum = 0;

            for (int i = 0; i < level; i++) {
                TreeNode element = queue.poll();
                if (element.left != null) {
                    sum += element.left.val;
                    queue.offer(element.left);
                }
                if (element.right != null) {
                    sum += element.right.val;
                    queue.offer(element.right);
                }
            }
            list.add(sum);
        }
        int n = list.size();
        Collections.sort(list);

        if (k >= list.size()) return -1;
        return list.get(n - k);
    }
}
