package JUST_CODES;

public class MaximumTwinSumOfLinkedList {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode nxt = node.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = nxt;
            if (nxt != null) nxt = nxt.next;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        int count = 1;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        slow.next = reverse(slow.next);

        ListNode first = head, second = slow.next;
        int ans = Integer.MIN_VALUE;

        while (count - 1 > 0) {
            int total = first.val + second.val;
            ans = Math.max(ans, total);
            first = first.next;
            second = second.next;
            count--;
        }
        return ans;
    }
}
