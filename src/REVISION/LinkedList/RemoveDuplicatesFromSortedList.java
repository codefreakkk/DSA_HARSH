package REVISION.LinkedList;

public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = deleteDuplicates(head.next);
        if (node.val == head.val) {
            return node;
        }
        head.next = node;
        return head;
    }


    public static void main(String[] args) {

    }

}
