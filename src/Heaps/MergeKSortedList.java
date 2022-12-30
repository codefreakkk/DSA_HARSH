package Heaps;

import java.util.*;

public class MergeKSortedList {

    class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
        }
    }
    class SortByData implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.data - l2.data;
        }
    }

    public ListNode mergeKSortedList(ListNode[] list) {
        int size = list.length;
        if (size == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new SortByData());

        for (int i = 0; i < size; i++) {
            if (list[i] != null)
                pq.offer(list[i]);
        }

        ListNode head = null, tail = null;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();

            if (top.next != null)
                pq.offer(top.next);

            if (head == null) {
                head = top;
                tail = top;
            }
            else {
                tail.next = top;
                tail = top;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
