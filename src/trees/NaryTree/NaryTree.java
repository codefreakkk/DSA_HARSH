package trees.NaryTree;

import java.util.*;

class Node {
    int data;
    List<Node> children;
    public Node(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}

public class NaryTree {
    public static Node insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter current root data");
        int data = sc.nextInt();

        Node root = new Node(data);

        System.out.println("Enter no. of children's for " + data);
        int childrens = sc.nextInt();

        for (int i = 0; i < childrens; i++) {
            Node child = insert();
            root.children.add(child);
        }
        return root;
    }

    // preorder traversal of nary tree
    public static List<Integer> solve(Node root, List<Integer> list) {
        if (root == null)
            return list;

        list.add(root.data);
        for (int i = 0; i < root.children.size(); i++)
            list = solve(root.children.get(i), list);

        return list;
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        list = solve(root, list);
        return list;
    }

    public static void main(String[] args) {
        Node root = insert();
        List<Integer> list = preorder(root);
        for (int i : list)
            System.out.println(i);
    }
}
