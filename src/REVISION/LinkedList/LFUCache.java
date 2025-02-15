package REVISION.LinkedList;

import java.util.*;

public class LFUCache {

    Map<Integer, LFUNode> cache;
    Map<Integer, LFULinkedList> frequencyMap;
    int capacity, minFrequency, currentSize;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.capacity = capacity;
        this.minFrequency = 0;
        this.currentSize = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        LFUNode node = cache.get(key);
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            LFUNode node = cache.get(key);
            node.val = value;
            updateNode(node);
        } else {
            currentSize++;
            if (currentSize > capacity) {
                LFULinkedList list = frequencyMap.get(minFrequency);
                cache.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
                currentSize--;
            }

            minFrequency = 1;
            LFUNode node = new LFUNode(key, value);

            LFULinkedList list = frequencyMap.getOrDefault(minFrequency, new LFULinkedList());
            list.insert(node);
            frequencyMap.put(minFrequency, list);
            cache.put(key, node);
        }
    }

    private void updateNode(LFUNode node) {
        int frequency = node.frequency;
        LFULinkedList list = frequencyMap.get(frequency);
        list.remove(node);

        if (frequency == minFrequency && list.listSize == 0) {
            minFrequency++;
        }

        node.frequency++;
        LFULinkedList newList = frequencyMap.getOrDefault(node.frequency, new LFULinkedList());
        newList.insert(node);
        frequencyMap.put(node.frequency, newList);
    }

    public static void main(String[] args) {

    }
}

class LFUNode {
    int frequency, val, key;
    LFUNode next, prev;
    public LFUNode(int key, int val) {
        this.val = val;
        this.key = key;
        this.frequency = 1;
    }
}

class LFULinkedList {

    int listSize;
    LFUNode head, tail;

    public LFULinkedList() {
        this.head = new LFUNode(-1, -1);
        this.tail = new LFUNode(-1, -1);
    }

    public void insert(LFUNode node) {
        LFUNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        this.listSize++;
    }

    public void remove(LFUNode node) {
        LFUNode next = node.next;
        LFUNode prev = node.prev;
        prev.next = next;
        next.prev = prev;
        this.listSize--;
    }

}
