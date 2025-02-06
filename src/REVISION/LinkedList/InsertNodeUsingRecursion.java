package REVISION.LinkedList;

public class InsertNodeUsingRecursion {

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    public InsertNodeUsingRecursion() {
        this.head = null;
    }

    public Node solve(int val, int index, Node current) {
        if (index == 0) {
            Node temp = new Node(val);
            temp.next = current;
            return temp;
        }

        Node node = solve(val, index - 1, current.next);
        current.next = node;
        return node;
    }

    public void insert(int val, int index) {
        head = solve(val, index, head);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " : ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InsertNodeUsingRecursion o = new InsertNodeUsingRecursion();
        o.insert(10, 0);
        o.insert(11, 1);
        o.insert(12, 2);
        o.display();
    }
}
