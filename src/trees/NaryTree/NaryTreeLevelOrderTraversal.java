package trees.NaryTree;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        // edge case
        if (root == null)
            return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node element = queue.poll();
                list.add(element.data);
                // push children of element in queue
                for (int j = 0; j < element.children.size(); j++)
                    queue.offer(element.children.get(j));

            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
