package omLinkedList;


// structure of singly linked list
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

public class SinglyLinkedList {

    Node head = null;

    public void insertFirst(int data) {

        // if no node in linked list
        if (head == null) {
            Node node = new Node(data);
            head = node;
            return;
        }

        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void insertLast(int data) {

        // if no node in linked list
        if (head == null) {
            Node node = new Node(data);
            head = node;
            return;
        }

        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        Node node = new Node(data);
        ptr.next = node;
    }

    public void insertInMiddle(int data, int index) {
        if (head == null) {
            Node node = new Node(data);
            head = node;
            return;
        }
        if (index == 0) {
            insertFirst(data);
            return;
        }

        Node ptr = head;
        for (int i = 0; i < index - 1; i++) {
            ptr = ptr.next;
        }

        Node node = new Node(data);
        Node temp = ptr.next;

        ptr.next = node;
        node.next = temp;
    }

    public void display() {
        Node ptr = head;

        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList obj = new SinglyLinkedList();

        obj.insertLast(10);
        obj.insertLast(20);
        obj.insertLast(30);
        obj.insertInMiddle(40, 0);

        obj.display();

    }
}
