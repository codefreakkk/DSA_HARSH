package REVISION.LinkedList;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node original = head;
        Node clone = dummy;

        while (original != null) {
            clone.next = new Node(original.val);
            original = original.next;
            clone = clone.next;
        }

        original = head;
        clone = dummy.next;
        while (original != null && clone != null) {
            Node temp = original.next;
            original.next = clone;
            original = temp;

            temp = clone.next;
            clone.next = original;
            clone = temp;
        }

        original = head;
        while (original != null) {
            if (original.next != null && original.random != null) {
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }

        original = head;
        clone = dummy.next;
        while (original != null && clone != null) {
            original.next = clone.next;
            original = original.next;

            if (original != null) {
                clone.next = original.next;
            }
            clone = clone.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
